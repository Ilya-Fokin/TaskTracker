package com.netcracker.Entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "Team")
@Table(name = "team")
public class Team {
    @Id
    @Type(type = "uuid-char")
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_team_lead")
    private User teamLead;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_project_team")
    private Project project;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<UserTeam> userTeams;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<TaskTeam> taskTeams;

    public Team() {}

    public Team(String name, User teamLead, Project project, List<UserTeam> userTeams, List<TaskTeam> taskTeams) {
        this.name = name;
        this.teamLead = teamLead;
        this.project = project;
        this.userTeams = userTeams;
        this.taskTeams = taskTeams;
    }

    public Team(String name, User teamLead, Project project, List<UserTeam> userTeams) {
        this.name = name;
        this.teamLead = teamLead;
        this.project = project;
        this.userTeams = userTeams;
    }

    public Team(String name, User teamLead, Project project) {
        this.name = name;
        this.teamLead = teamLead;
        this.project = project;
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

    public User getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(User teamLead) {
        this.teamLead = teamLead;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<UserTeam> getUserTeams() {
        return userTeams;
    }

    public void setUserTeams(List<UserTeam> userTeams) {
        this.userTeams = userTeams;
    }

    public List<TaskTeam> getTaskTeams() {
        return taskTeams;
    }

    public void setTaskTeams(List<TaskTeam> taskTeams) {
        this.taskTeams = taskTeams;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamLead=" + teamLead +
                ", project=" + project +
                ", userTeams=" + userTeams +
                ", taskTeams=" + taskTeams +
                '}';
    }
}
