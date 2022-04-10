package com.netcracker.Service.ProjectService;

import com.netcracker.Entity.Project;
import com.netcracker.Entity.Team;
import com.netcracker.Entity.User;
import com.netcracker.Entity.UserProject;
import com.netcracker.Exceptions.ProjectExceptions.ProjectAlreadyExistException;
import com.netcracker.Exceptions.UserExceptions.UserAlreadyExistException;
import com.netcracker.Repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    ProjectRepo projectRepo;

    @Override
    public void create(String name, String description, LocalDateTime closingDate, boolean visibility, User user) {
        if (findByName(name) != null) {
            throw new ProjectAlreadyExistException("Проект с таким названием уже сущетсвует");
        } else {
            Project project = new Project(user, name, description, closingDate, visibility);
            UserProject userProject = new UserProject(user, project);
            project.addUserProject(userProject);
            projectRepo.save(project);
        }
    }

    @Override
    public void updateName(Project project, User user, String name) {
        if (projectRepo.findByName(name) == null && project.getAdminProject().equals(user)) {
            project.setName(name);
            projectRepo.save(project);
        }
    }

    @Override
    public void updateDescription(Project project, User user, String description) {
        if (project.getAdminProject().equals(user)) {
            project.setDescription(description);
            projectRepo.save(project);
        }
    }

    @Override
    public void updateClosingDate(Project project, User user, LocalDateTime closingDate) {
        if (project.getAdminProject().equals(user)) {
            project.setClosingTime(closingDate);
            projectRepo.save(project);
        }
    }

    @Override
    public void updateVisibility(Project project, User user, boolean visibility) {
        if (project.getAdminProject().equals(user)) {
            project.setVisibility(visibility);
            projectRepo.save(project);
        }
    }

    @Override
    public void addParticipant(Project project, User admin, User user) {
        if (project.getAdminProject().equals(admin)) {
            for (UserProject userProject : project.getUserProjects()) {
                if (userProject.getUser().equals(user)) {
                    throw new UserAlreadyExistException(String.format("Пользователь '%s' уже в проекте", user.getNickname()));
                }
            }
            project.getUserProjects().add(new UserProject(user, project));
            projectRepo.save(project);
        }
    }

    @Override
    public Project findByName(String name) {
        Project project = projectRepo.findByName(name);
        if (project == null) {
            return null;
        } else return project;
    }

    @Override
    public List<Project> getAllProjects() {
        return (List<Project>) projectRepo.findAll();
    }

    @Override
    public List<User> getAllParticipant(Project project) {
        List<User> users = new ArrayList<>();
        project.getUserProjects().forEach(x -> users.add(x.getUser()));
        return users;
    }


}
