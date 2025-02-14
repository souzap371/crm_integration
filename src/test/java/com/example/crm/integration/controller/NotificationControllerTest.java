package com.example.crm.integration.controller;


import com.example.crm.integration.dto.NotificationRequestDto;
import com.example.crm.integration.service.NotificationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(NotificationController.class)
public class NotificationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NotificationService notificationService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSendPushNotification() throws Exception {
        NotificationRequestDto dto = new NotificationRequestDto();
        dto.setBeneficiaryId("benef123");
        dto.setMessage("Test push notification");

        // Simula sucesso no envio da notificação
        Mockito.doNothing().when(notificationService).sendPushNotification(any(NotificationRequestDto.class));

        mockMvc.perform(post("/api/notifications/push")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(content().string("Push notification sent successfully"));
    }
}
