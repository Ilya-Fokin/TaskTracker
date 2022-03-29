package com.netcracker.Domains;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "Project")
@Table(name = "project")
public class Project {
    @Id
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    private final UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "closing_date")
    private LocalDateTime dateTime;

    @Column(name = "visibility")
    private boolean visibility;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_project_admin")
    private User adminProject;

    @OneToMany(mappedBy = "project")
    private List<UserProject> userProjects;
}
