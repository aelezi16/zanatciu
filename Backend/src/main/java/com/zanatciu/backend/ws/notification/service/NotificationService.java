package com.zanatciu.backend.ws.notification.service;

import com.google.gson.Gson;
import com.zanatciu.backend.ws.notification.model.Notification;
import com.zanatciu.backend.ws.notification.repo.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class NotificationService {


    private NotificationRepo notificationRepo;
    private KafkaTemplate<String, String> kafkaTemplate;
    private Gson jsonConverter;

    @Autowired
    public NotificationService(
            NotificationRepo notificationRepo,
            KafkaTemplate<String, String> kafkaTemplate,
            Gson jsonConverter
    ) {
        this.notificationRepo = notificationRepo;
        this.kafkaTemplate = kafkaTemplate;
        this.jsonConverter =jsonConverter;
    }


    public void saveAndSend(Notification notification) {

        notificationRepo.save(notification);
        kafkaTemplate.send("NOTIFICATION", jsonConverter.toJson(notification));
    }


    public List<Notification> getAllByUsernameAndStatus(String username, String status) {
        return notificationRepo.findAllByStatusAndUsername(status, username);
    }

}
