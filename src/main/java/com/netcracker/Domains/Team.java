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
}
