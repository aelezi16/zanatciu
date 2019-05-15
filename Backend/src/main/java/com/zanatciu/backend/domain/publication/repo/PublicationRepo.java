package com.zanatciu.backend.domain.publication.repo;

import com.zanatciu.backend.domain.publication.model.Publication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublicationRepo extends MongoRepository<Publication, String> {
    Optional<Publication> findById(String id);
    List<Publication> findAllByUsernameAndType(String username, String type);
    List<Publication> findAllByType(String type);
    void deleteById(String id);
}
