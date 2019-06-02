package com.zanatciu.backend.domain.profile.repo;

import com.zanatciu.backend.domain.profile.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepo extends MongoRepository<Profile, String> {
    Optional<Profile> findById(String id);
    Profile save(Profile profile);
}
