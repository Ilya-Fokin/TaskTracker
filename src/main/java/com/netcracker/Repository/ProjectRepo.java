package com.netcracker.Repository;

import com.netcracker.Domains.Project;
import com.netcracker.Domains.User;
import com.netcracker.Domains.UserProject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectRepo extends CrudRepository<Project, UUID> {
    @Override
    Optional<Project> findById(UUID uuid);
    Project findByName(String name);
}
