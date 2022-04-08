package com.netcracker.Entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "Task")
@Table(name = "task")
public class Task {
    @Id
    @Type(type = "uuid-char")
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "closing_date")
    private LocalDateTime dateTime;

    @Column(name = "status")
    private boolean status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_project_task")
    private Project project;

    @OneToMany(mappedBy = "task")
    private List<TaskTeam> taskTeams;

    @OneToMany(mappedBy = "task")
    private List<TaskUser> taskUser;

    public Task() {}

    public Task(String name, String description, LocalDateTime dateTime, boolean status, Project project, List<TaskTeam> taskTeams, List<TaskUser> taskUser) {
        this.name = name;
        this.description = description;
        this.dateTime = dateTime;
        this.status = status;
        this.project = project;
        this.taskTeams = taskTeams;
        this.taskUser = taskUser;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<TaskTeam> getTaskTeams() {
        return taskTeams;
    }

    public void setTaskTeams(List<TaskTeam> taskTeams) {
        this.taskTeams = taskTeams;
    }

    public List<TaskUser> getTaskUser() {
        return taskUser;
    }

    public void setTaskUser(List<TaskUser> taskUser) {
        this.taskUser = taskUser;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", status=" + status +
                ", project=" + project +
                ", taskTeams=" + taskTeams +
                ", taskUser=" + taskUser +
                '}';
    }
}
