package com.netcracker.Repository;

import com.netcracker.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends CrudRepository<User, UUID> {
    @Override
    Optional<User> findById(UUID uuid);
    @Override
    Iterable<User> findAllById(Iterable<UUID> uuids);
    User findByNickname(String nickName);
    User findByName(String name);
}
