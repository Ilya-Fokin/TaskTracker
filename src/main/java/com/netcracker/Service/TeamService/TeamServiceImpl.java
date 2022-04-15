package com.netcracker.Service.TeamService;

import com.netcracker.Entity.Project;
import com.netcracker.Entity.Team;
import com.netcracker.Entity.User;
import com.netcracker.Entity.UserTeam;
import com.netcracker.Exceptions.AccessResrictionsException.NoAccessException;
import com.netcracker.Exceptions.TeamExceptions.TeamAlreadyExistException;
import com.netcracker.Exceptions.TeamExceptions.TeamNotFoundException;
import com.netcracker.Exceptions.UserExceptions.UserAlreadyExistException;
import com.netcracker.Repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class TeamServiceImpl implements TeamService{
    @Autowired
    TeamRepo teamRepo;

    @Override
    public void create(String name, UUID adminId, User teamLead, Project project) {
        if (project.getAdminProject().getId().equals(adminId)) {
            teamRepo.findAllTeamByProject(project).forEach(x -> {
                if ((x.getName()).equals(name)) {
                    throw new TeamAlreadyExistException("Команада с таким именем уже существует");
                }
            });
            Team team = new Team(name, teamLead, project);
            team.getUserTeams().add(new UserTeam(teamLead, team));
            teamRepo.save(team);
        } else throw new NoAccessException(String .format("Вы не являетесь администратором проекта '%s'", project.getName()));
    }

    @Override
    public void addParticipant(UUID teamId, UUID teamLeadId, User... users) {
        if (teamRepo.findById(teamId).isPresent()) {
            Team team = teamRepo.findById(teamId).get();
            if (team.getTeamLead().getId().equals(teamLeadId)) {
                for (User user : users) {
                    if (findParticipantByNickname(team, user.getNickname()) == null) {
                        team.getUserTeams().add(new UserTeam(user, team));
                    } else throw new UserAlreadyExistException("Пользователь уже состоит в команде");
                }
                teamRepo.save(team);
            } else throw new NoAccessException("Недостаточно прав");
        } else throw new TeamNotFoundException("Команда не найдена");
    }

    @Override
    public List<Team> findAllByProject(Project project) {
        return teamRepo.findAllTeamByProject(project);
    }

    @Override
    public List<User> findAllParticipant(Team team) {
        List<User> users = new ArrayList<>();
        team.getUserTeams().forEach(x -> users.add(x.getUser()));
        return users;
    }

    @Override
    public User findParticipantByNickname(Team team, String nickname) {
        User user = null;
        for (UserTeam userTeam : team.getUserTeams()) {
            if (userTeam.getUser().getNickname().equals(nickname)) {
                user = userTeam.getUser();
            }
        }
        return user;
    }

    @Override
    public void deleteParticipant(UUID teamId, UUID teamLeadId, User... users) {
        if (teamRepo.findById(teamId).isPresent()) {
            Team team = teamRepo.findById(teamId).get();
            if (team.getTeamLead().getId().equals(teamLeadId)) {
                for (UserTeam userTeam : team.getUserTeams()) {
                    for (User user : users) {
                        if (userTeam.getUser().equals(user)) {
                            userTeam.setEndDate(LocalDateTime.now());
                            userTeam.setStatus(false);
                        }
                    }
                }
                teamRepo.save(team);
            } else throw new NoAccessException("Недостаточно прав");
        } else throw new TeamNotFoundException("Команда не найдена");
    }

    @Override
    public Team delete(Team team, UUID userId) {
        Team teamInRepo = teamRepo.findByName(team.getName());
        if (teamInRepo != null) {
            if (teamInRepo.getTeamLead().getId().equals(userId) || teamInRepo.getProject().getAdminProject().getId().equals(userId)) {
                teamRepo.delete(team);
                return team;
            } else throw new NoAccessException("Недостаточно прав");
        } else throw new TeamNotFoundException(String.format("Команда %s не найдена", team.getName()));
    }
}
