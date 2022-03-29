package com.netcracker.Domains;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "Task")
@Table(name = "task")
public class Task {
    @Id
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    private final UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "closing_date")
    private LocalDateTime dateTime;

    @Column(name = "status")
    private boolean status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_project")
    private Project project;

    @OneToMany(mappedBy = "task")
    private List<TaskTeam> taskTeams;

    @OneToMany(mappedBy = "task")
    private List<TaskUser> taskUser;
}
