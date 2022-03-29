package com.netcracker.Domains;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "Team")
@Table(name = "team")
public class Team {
    @Id
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    private final UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_team_lead")
    private User teamLead;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_project")
    private Project project;

    @OneToMany(mappedBy = "team")
    private List<UserTeam> userTeams;

    @OneToMany(mappedBy = "team")
    private List<TaskTeam> taskTeams;

    public Team() {}

    public Team(String name, User teamLead, Project project, List<UserTeam> userTeams, List<TaskTeam> taskTeams) {
        this.name = name;
        this.teamLead = teamLead;
        this.project = project;
        this.userTeams = userTeams;
        this.taskTeams = taskTeams;
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
}
