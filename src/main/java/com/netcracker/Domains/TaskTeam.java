package com.netcracker.Domains;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "task2team")
public class TaskTeam {
    @Id
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    private final UUID id = UUID.randomUUID();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_task")
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_team")
    private Team team;

    public TaskTeam() {}

    public TaskTeam(Task task, Team team) {
        this.task = task;
        this.team = team;
    }

    public UUID getId() {
        return id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
