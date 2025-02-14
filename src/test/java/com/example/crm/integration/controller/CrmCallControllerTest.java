package com.example.crm.integration.controller;


import com.example.crm.integration.dto.CrmCallDto;
import com.example.crm.integration.model.CrmCall;
import com.example.crm.integration.service.CrmCallService;
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

@WebMvcTest(CrmCallController.class)
public class CrmCallControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CrmCallService crmCallService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateOrUpdateCrmCall() throws Exception {
        CrmCallDto dto = new CrmCallDto();
        dto.setCrmId("123");
        dto.setMotive("Motivo teste");
        dto.setStatus("OPEN");
        dto.setObservation("Observação teste");

        CrmCall crmCall = new CrmCall(dto.getCrmId(), dto.getMotive(), dto.getStatus(), dto.getObservation());
        Mockito.when(crmCallService.createOrUpdateCrmCall(any(CrmCallDto.class))).thenReturn(crmCall);

        mockMvc.perform(post("/api/crm-calls")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.crmId").value("123"))
                .andExpect(jsonPath("$.motive").value("Motivo teste"));
    }
}

