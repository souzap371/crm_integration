package com.example.crm.integration.controller;


import com.example.crm.integration.dto.WebhookCallDto;
import com.example.crm.integration.model.WebhookCall;
import com.example.crm.integration.service.WebhookService;
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

@WebMvcTest(WebhookController.class)
public class WebhookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WebhookService webhookService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testReceiveWebhook() throws Exception {
        WebhookCallDto dto = new WebhookCallDto();
        dto.setPayload("Test payload");

        WebhookCall webhookCall = new WebhookCall(dto.getPayload());
        Mockito.when(webhookService.processWebhookCall(any(WebhookCallDto.class))).thenReturn(webhookCall);

        mockMvc.perform(post("/api/webhook/calls")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.payload").value("Test payload"));
    }
}
