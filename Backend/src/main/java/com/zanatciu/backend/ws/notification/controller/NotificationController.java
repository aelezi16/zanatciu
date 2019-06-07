package com.zanatciu.backend.ws.notification.controller;

import com.zanatciu.backend.ws.notification.model.Notification;
import com.zanatciu.backend.ws.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private NotificationService notificationService;

    @Autowired
    public NotificationController(
            NotificationService notificationService
    ) {
        this.notificationService = notificationService;
    }

    @GetMapping("/all")
    public List<Notification> getAll(@RequestParam String status, @RequestParam String username) {
        return notificationService.getAllByUsernameAndStatus(username, status);
    }


}
