package com.example.crm.integration.controller;


import com.example.crm.integration.dto.CrmCallDto;
import com.example.crm.integration.model.CrmCall;
import com.example.crm.integration.service.CrmCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/crm-calls")
public class CrmCallController {

    @Autowired
    private CrmCallService crmCallService;

    // Endpoint para criação/atualização do chamado
    @PostMapping
    public ResponseEntity<CrmCall> createOrUpdateCrmCall(@RequestBody CrmCallDto crmCallDto) {
        CrmCall call = crmCallService.createOrUpdateCrmCall(crmCallDto);
        return ResponseEntity.ok(call);
    }
}
