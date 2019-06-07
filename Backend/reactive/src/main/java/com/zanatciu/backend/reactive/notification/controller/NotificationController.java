package com.zanatciu.backend.reactive.notification.controller;

import com.google.gson.Gson;
import com.zanatciu.backend.reactive.notification.model.ReactiveNotification;
import com.zanatciu.backend.reactive.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.Duration;


@RestController
@RequestMapping("/notification")
public class NotificationController {

    private NotificationService notificationService;
    private Gson jsonConverter;

    @Autowired
    public NotificationController(
            NotificationService notificationService,
            Gson jsonConverter
    ) {
        this.notificationService = notificationService;
        this.jsonConverter = jsonConverter;
    }



    @GetMapping(value="{username}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<ReactiveNotification> getAllAsEvent(@PathVariable String username) {
        return notificationService.getOnSave(username).delayElements(Duration.ofSeconds(1));
    }
}
