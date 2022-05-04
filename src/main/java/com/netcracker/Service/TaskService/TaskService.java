package com.netcracker.Service.TaskService;

import com.netcracker.Entity.Project;
import com.netcracker.Entity.Task;
import com.netcracker.Entity.Team;
import com.netcracker.Entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface TaskService {
    void create(UUID adminId, String name, String description, LocalDateTime closingDate, Project project, User user, Team team);
    Task findByNameAndTeam(String name, Team team);
    List<Task> findAllByTeam(Team team);
}
