package com.zanatciu.backend.domain.application.repo;

import com.zanatciu.backend.domain.application.model.Application;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepo extends MongoRepository<Application, String> {
    List<Application> findAllByPublicationId(String publicationId);

    Optional<Application> findById(String id);
    }
