package com.example.crm.integration.service;


import com.example.crm.integration.dto.WebhookCallDto;
import com.example.crm.integration.model.WebhookCall;
import com.example.crm.integration.repository.WebhookCallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebhookService {

    @Autowired
    private WebhookCallRepository webhookCallRepository;

    public WebhookCall processWebhookCall(WebhookCallDto dto) {
        WebhookCall webhookCall = new WebhookCall(dto.getPayload());
        return webhookCallRepository.save(webhookCall);
    }
}
