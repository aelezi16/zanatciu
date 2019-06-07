package com.zanatciu.backend.ws.notification.repo;

import com.zanatciu.backend.ws.notification.model.Notification;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepo extends MongoRepository<Notification, String> {

    List<Notification> findAllByStatusAndUsername(String status, String username);

    List<Notification> findAll();
}
