package com.netcracker.Repository;

import com.netcracker.Entity.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProjectRepo extends CrudRepository<Project, UUID> {
    @Override
    Optional<Project> findById(UUID uuid);
    Project findByName(String name);
}
