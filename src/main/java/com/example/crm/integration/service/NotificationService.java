package com.example.crm.integration.service;


import com.example.crm.integration.dto.NotificationRequestDto;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    // Simulação de envio de push notification
    public void sendPushNotification(NotificationRequestDto dto) {
        // Em uma implementação real, integre com um serviço de push (ex.: Firebase)
        System.out.println("Enviando push notification para beneficiário: " 
            + dto.getBeneficiaryId() + " com mensagem: " + dto.getMessage());
        // Simula sucesso no envio
    }
}
