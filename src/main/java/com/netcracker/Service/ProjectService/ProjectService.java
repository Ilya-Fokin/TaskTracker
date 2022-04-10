package com.netcracker.Service.ProjectService;

import com.netcracker.Entity.Project;
import com.netcracker.Entity.Team;
import com.netcracker.Entity.User;

import java.time.LocalDateTime;
import java.util.List;

public interface ProjectService {
    void create(String name, String description, LocalDateTime closingDate, boolean visibility, User user);
    void updateName(Project project, User user, String name);
    void updateDescription(Project project, User user, String description);
    void updateClosingDate(Project project, User user, LocalDateTime closingDate);
    void updateVisibility(Project project, User user, boolean visibility);
    void addParticipant(Project project, User admin, User user);
    Project findByName(String name);
    List<Project> getAllProjects();
    List<User> getAllParticipant(Project project);
}
