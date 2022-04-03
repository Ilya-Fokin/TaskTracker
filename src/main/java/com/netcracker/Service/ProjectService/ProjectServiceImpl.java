package com.netcracker.Service.ProjectService;

import com.netcracker.Domains.Project;
import com.netcracker.Domains.User;
import com.netcracker.Domains.UserProject;
import com.netcracker.Exceptions.UserExceptions.UserIsExistInProjectException;
import com.netcracker.Repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Iterator;

@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    ProjectRepo projectRepo;

    @Override
    public void createProject(String name, String description, LocalDateTime closingDate, boolean visibility, User user) {
        Project project = new Project(user, name, description, closingDate, visibility);
        UserProject userProject = new UserProject(user, project);
        project.addUserProject(userProject);
        projectRepo.save(project);
    }

    @Override
    public void updateNameProject(Project project, String name) {
        if (projectRepo.findByName(name) == null) {
            project.setName(name);
            projectRepo.save(project);
        }
    }

    @Override
    public void updateDescriptionProject(Project project, String description) {
        project.setDescription(description);
        projectRepo.save(project);
    }

    @Override
    public void updateClosingDateProject(Project project, LocalDateTime closingDate) {
        project.setClosingTime(closingDate);
        projectRepo.save(project);
    }

    @Override
    public void updateVisibilityProject(Project project, boolean visibility) {
        project.setVisibility(visibility);
        projectRepo.save(project);
    }

    @Override
    public void addProjectParticipant(Project project, User user) {
        for (UserProject userProject : project.getUserProjects()) {
            if (userProject.getUser().equals(user)) {
                throw new UserIsExistInProjectException(String.format("Пользователь '%s' уже в проекте", user.getNickname()));
            }
        }
        project.getUserProjects().add(new UserProject(user, project));
        projectRepo.save(project);
    }

    @Override
    public Project findByName(String name) {
        Project project = projectRepo.findByName(name);

        if (project == null) {
            return null;
        } else return project;
    }
}
