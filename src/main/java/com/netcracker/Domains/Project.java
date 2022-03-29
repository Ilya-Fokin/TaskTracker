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

    public Project() {}

    public Project(String name, String description, LocalDateTime dateTime, boolean visibility, User adminProject, List<UserProject> userProjects) {
        this.name = name;
        this.description = description;
        this.dateTime = dateTime;
        this.visibility = visibility;
        this.adminProject = adminProject;
        this.userProjects = userProjects;
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

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public User getAdminProject() {
        return adminProject;
    }

    public void setAdminProject(User adminProject) {
        this.adminProject = adminProject;
    }

    public List<UserProject> getUserProjects() {
        return userProjects;
    }

    public void setUserProjects(List<UserProject> userProjects) {
        this.userProjects = userProjects;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
