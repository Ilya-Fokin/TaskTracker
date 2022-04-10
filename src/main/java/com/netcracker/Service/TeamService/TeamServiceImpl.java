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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{
    @Autowired
    TeamRepo teamRepo;

    @Override
    public void create(String name, User teamLead, Project project) {
        if (project.getAdminProject().equals(teamLead)) {
            teamRepo.findAllByProject(project).forEach(x -> {
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
    public void addParticipant(Team team, User... users) {
            for (User user : users) {
                if (findParticipantByNickname(team, user.getNickname()) == null) {
                    team.getUserTeams().add(new UserTeam(user, team));
                }
            }
            teamRepo.save(team);
    }

    @Override
    public List<Team> findAllByProject(Project project) {
        return teamRepo.findAllByProject(project);
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
    public void deleteParticipant(Team team, User... users) {
        for (UserTeam userTeam : team.getUserTeams()) {
            for (User user : users) {
                if (userTeam.getUser().equals(user)) {
                    userTeam.setEndDate(LocalDateTime.now());
                }
            }
        }
        teamRepo.save(team);
    }

    @Override
    public Team delete(Team team) {
        if (teamRepo.findByName(team.getName()) != null) {
            teamRepo.delete(team);
            return team;
        } else throw new TeamNotFoundException(String.format("Команда %s не найдена", team.getName()));
    }
}
