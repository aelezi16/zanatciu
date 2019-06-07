package com.zanatciu.backend.reactive.notification.repo;

import com.zanatciu.backend.reactive.notification.model.ReactiveNotification;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

public interface ReactiveNotificationRepo
        extends ReactiveCrudRepository<ReactiveNotification, String> {

    @Tailable
    Flux<ReactiveNotification> findReactiveNotificationsByUsername(String username);
}
