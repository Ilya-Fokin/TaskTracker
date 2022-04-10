package com.netcracker.Service.TeamService;

import com.netcracker.Entity.Project;
import com.netcracker.Entity.Team;
import com.netcracker.Entity.User;

import java.util.List;

public interface TeamService {
    void create(String name, User user, Project project);
    void addParticipant(Team team, User... user);
    List<Team> findAllByProject(Project project);
    List<User> findAllParticipant(Team team);
    User findParticipantByNickname(Team team, String nickname);
    void deleteParticipant(Team team, User... user);
    Team delete(Team team);
}
