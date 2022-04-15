package com.netcracker.Repository;

import com.netcracker.Entity.Project;
import com.netcracker.Entity.Team;
import com.netcracker.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TeamRepo extends CrudRepository<Team, UUID> {
    Team findByName(String name);
    Team findByTeamLead(User user);
    List<Team> findAllTeamByProject(Project project);
    Optional<Team> findById(UUID id);
}
