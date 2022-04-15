package com.netcracker.Service.TeamService;

import com.netcracker.Entity.Project;
import com.netcracker.Entity.Team;
import com.netcracker.Entity.User;

import java.util.List;
import java.util.UUID;

public interface TeamService {
    void create(String name, UUID adminId, User teamLead, Project project);
    void addParticipant(UUID teamId, UUID id, User... user);
    List<Team> findAllByProject(Project project);
    List<User> findAllParticipant(Team team);
    User findParticipantByNickname(Team team, String nickname);
    void deleteParticipant(UUID teamId, UUID id, User... user);
    Team delete(Team team, UUID id);
}
