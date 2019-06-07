package com.zanatciu.backend.domain.user.repo;

import com.zanatciu.backend.domain.user.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
    void deleteById(String id);

    Optional<User> findByUsername(String username);

    Optional<User> findById(String id);

    Optional<User> findByEmail(String email);

    List<User> findAll();
}