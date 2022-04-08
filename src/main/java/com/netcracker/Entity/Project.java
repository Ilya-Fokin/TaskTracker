package com.netcracker.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Entity(name = "Project")
@Table(name = "project")
public class Project {
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
    private LocalDateTime closingDate;

    @Column(name = "visibility")
    private boolean visibility;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_project_admin")
    private User adminProject;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<UserProject> userProjects = new ArrayList<>();

    public Project() {}

    public Project(User adminProject, String name, String description, LocalDateTime closingDate, boolean visibility, UserProject... userProject) {
        this.name = name;
        this.description = description;
        this.closingDate = closingDate;
        this.visibility = visibility;
        this.adminProject = adminProject;
        userProjects.addAll(Arrays.asList(userProject));
    }

    public Project(User user, String name, String description, LocalDateTime closingDate, boolean visibility) {
        this.name = name;
        this.description = description;
        this.closingDate = closingDate;
        this.visibility = visibility;
        this.adminProject = user;
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

    public LocalDateTime getClosingTime() {
        return closingDate;
    }

    public void setClosingTime(LocalDateTime closingDate) {
        this.closingDate = closingDate;
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

    public void addUserProject(UserProject userProject) {this.userProjects.add(userProject);}

    @Override
    public String toString() {
        return super.toString();
    }
}
