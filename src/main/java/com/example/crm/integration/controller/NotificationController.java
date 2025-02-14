package com.example.crm.integration.controller;


import com.example.crm.integration.dto.NotificationRequestDto;
import com.example.crm.integration.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // Endpoint para envio de push notification
    @PostMapping("/push")
    public ResponseEntity<String> sendPushNotification(@RequestBody NotificationRequestDto notificationRequestDto) {
        notificationService.sendPushNotification(notificationRequestDto);
        return ResponseEntity.ok("Push notification sent successfully");
    }
}
