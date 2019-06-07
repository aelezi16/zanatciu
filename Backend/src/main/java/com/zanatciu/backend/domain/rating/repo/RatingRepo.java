package com.zanatciu.backend.domain.rating.repo;

import com.zanatciu.backend.domain.rating.model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepo extends MongoRepository<Rating, String> {
    Optional<Rating> findById(String id);

    List<Rating> findAllByPublicationId(String publicationId);

    List<Rating> findAllByUsername(String username);

    void deleteById(String id);
}
