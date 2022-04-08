package com.netcracker.Service.ProjectService;

import com.netcracker.Entity.Project;
import com.netcracker.Entity.User;

import java.time.LocalDateTime;
import java.util.List;

public interface ProjectService {
    void createProject(String name, String description, LocalDateTime closingDate, boolean visibility, User user);
    void updateNameProject(Project project, String name);
    void updateDescriptionProject(Project project, String description);
    void updateClosingDateProject(Project project, LocalDateTime closingDate);
    void updateVisibilityProject(Project project, boolean visibility);
    void addProjectParticipant(Project project, User user);
    Project findByName(String name);
}
