package com.netcracker.Domains;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "User")
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    private final UUID id = UUID.randomUUID();

    @Column(name = "first_last_name")
    private String name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<UserProject> userProjects;

    @OneToMany(mappedBy = "user")
    private List<UserTeam> userTeams;
}
