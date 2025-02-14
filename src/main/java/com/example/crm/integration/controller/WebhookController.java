package com.example.crm.integration.controller;


import com.example.crm.integration.dto.WebhookCallDto;
import com.example.crm.integration.model.WebhookCall;
import com.example.crm.integration.service.WebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webhook")
public class WebhookController {

    @Autowired
    private WebhookService webhookService;

    // Endpoint para receber chamadas via webhook
    @PostMapping("/calls")
    public ResponseEntity<WebhookCall> receiveWebhook(@RequestBody WebhookCallDto webhookCallDto) {
        WebhookCall webhookCall = webhookService.processWebhookCall(webhookCallDto);
        return ResponseEntity.ok(webhookCall);
    }
}
