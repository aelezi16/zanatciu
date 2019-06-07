package com.zanatciu.backend.reactive.notification.service;


import com.google.gson.Gson;
import com.zanatciu.backend.reactive.notification.model.ReactiveNotification;
import com.zanatciu.backend.reactive.notification.repo.ReactiveNotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.time.Duration;

@Service
public class NotificationService {

    private ReactiveMongoTemplate reactiveMongoTemplate;
    private ReactiveNotificationRepo reactiveNotificationRepo;
    private Gson jsonConverter;


    @Autowired
    public NotificationService(
            ReactiveMongoTemplate reactiveMongoTemplate,
            ReactiveNotificationRepo reactiveNotificationRepo,
            Gson jsonConverter
    ) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
        this.reactiveNotificationRepo = reactiveNotificationRepo;
        this.jsonConverter = jsonConverter;
    }

    @PostConstruct
    public void configure() {
        reactiveMongoTemplate.dropCollection("ReactiveNotification")
                .then(
                        reactiveMongoTemplate.createCollection(
                                "ReactiveNotification", CollectionOptions.empty().capped().size(4096).maxDocuments(10000)
                        )
                ).subscribe();
    }

    @KafkaListener(topics = "NOTIFICATION")
    public void saveAndSend(String notification) {
        ReactiveNotification reactiveNotification = jsonConverter.fromJson(notification, ReactiveNotification.class);

        System.out.println(notification);
        reactiveNotification.setId(null);
        Mono<ReactiveNotification> saved = reactiveNotificationRepo.save(ReactiveNotification.builder().id(reactiveNotification.getId()).username(reactiveNotification.getUsername()).build());


        saved.subscribe(s->
                System.out.println(jsonConverter.toJson(s))
        );
    }

    public Flux<ReactiveNotification> getOnSave(String username) {
        return reactiveNotificationRepo.findReactiveNotificationsByUsername(username);
    }


}
