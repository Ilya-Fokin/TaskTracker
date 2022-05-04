package com.netcracker.Service.TaskService;

import com.netcracker.Entity.*;
import com.netcracker.Exceptions.AccessResrictionsException.NoAccessException;
import com.netcracker.Exceptions.TaskExceptions.TaskAlreadyExistException;
import com.netcracker.Repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskRepo taskRepo;

    @Override
    public void create(UUID adminId, String name, String description, LocalDateTime closingDate, Project project, User user, Team team) {
        if (project.getAdminProject().getId().equals(adminId) || team.getTeamLead().getId().equals(adminId)) {
            if (findByNameAndTeam(name, team) == null) {
                Task task = new Task(name, description, closingDate, project);
                TaskUser taskUser = new TaskUser(user, task);
                task.getTaskUser().add(taskUser);
                TaskTeam taskTeam = new TaskTeam();
            } else throw new TaskAlreadyExistException("Задача с таким названием уже существует в команде");
        } else throw new NoAccessException("Недостаточно прав для создания задачи");
    }

    @Override
    public Task findByNameAndTeam(String name, Team team) {
        for (Task task : findAllByTeam(team)) {
            if (task.getName().equals(name)) {
                return task;
            }
        }
        return null;
    }

    @Override
    public List<Task> findAllByTeam(Team team) {
        List<Task> tasks = new ArrayList<>();
        team.getTaskTeams().forEach(x -> tasks.add(x.getTask()));
        return tasks;
    }
}
