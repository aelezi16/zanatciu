package com.zanatciu.backend.domain.card.repo;

import com.zanatciu.backend.domain.card.model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepo extends MongoRepository<Card, String> {
    Optional<Card> findById(String id);
    List<Card> findCardsByUsername(String username);
}
