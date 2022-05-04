package com.netcracker.Repository;

import com.netcracker.Entity.Project;
import com.netcracker.Entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepo extends CrudRepository<Task, UUID> {
    Optional<Task> findById(UUID id);
    Task findByName(String name);
    List<Task> findByProject(Project project);
}
