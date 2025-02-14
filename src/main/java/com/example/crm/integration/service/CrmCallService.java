package com.example.crm.integration.service;


import com.example.crm.integration.dto.CrmCallDto;
import com.example.crm.integration.exception.ResourceNotFoundException;
import com.example.crm.integration.model.CrmCall;
import com.example.crm.integration.repository.CrmCallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrmCallService {

    @Autowired
    private CrmCallRepository crmCallRepository;

    // Cria ou atualiza o chamado, de acordo com o crmId
    public CrmCall createOrUpdateCrmCall(CrmCallDto dto) {
        CrmCall crmCall = crmCallRepository.findByCrmId(dto.getCrmId())
                .orElse(new CrmCall(dto.getCrmId(), dto.getMotive(), dto.getStatus(), dto.getObservation()));

        // Se o chamado já existe, atualiza status e observação
        crmCall.setStatus(dto.getStatus());
        crmCall.setObservation(dto.getObservation());
        // Atualiza o motivo se for fornecido
        if(dto.getMotive() != null){
            crmCall.setMotive(dto.getMotive());
        }
        crmCall.setUpdatedAt(java.time.LocalDateTime.now());
        return crmCallRepository.save(crmCall);
    }

    public CrmCall getCrmCallById(String crmId) {
        return crmCallRepository.findByCrmId(crmId)
                .orElseThrow(() -> new ResourceNotFoundException("CRM call not found with id: " + crmId));
    }
}
