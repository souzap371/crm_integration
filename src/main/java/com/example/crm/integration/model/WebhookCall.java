package com.example.crm.integration.model;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class WebhookCall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Armazena o payload recebido do webhook
    @Lob
    private String payload;

    private LocalDateTime receivedAt;

    public WebhookCall() {
        this.receivedAt = LocalDateTime.now();
    }

    public WebhookCall(String payload) {
        this.payload = payload;
        this.receivedAt = LocalDateTime.now();
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public LocalDateTime getReceivedAt() {
        return receivedAt;
    }
}
