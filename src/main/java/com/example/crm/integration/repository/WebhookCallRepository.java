package com.example.crm.integration.repository;


import com.example.crm.integration.model.WebhookCall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebhookCallRepository extends JpaRepository<WebhookCall, Long> {
}
