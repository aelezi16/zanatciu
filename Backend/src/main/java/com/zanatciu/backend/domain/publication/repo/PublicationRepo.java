package com.zanatciu.backend.domain.publication.repo;

import com.zanatciu.backend.domain.publication.model.Publication;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublicationRepo extends PagingAndSortingRepository<Publication, String> {
    List<Publication> findAll();

    Optional<Publication> findById(String id);

    Optional<Publication> findByTitle(String title);

    List<Publication> findAllByUsernameAndType(String username, String type);

    List<Publication> findAllByType(String type, Pageable pageable);

    void deleteById(String id);
}
