package com.example.crm.integration.repository;


import com.example.crm.integration.model.CrmCall;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CrmCallRepository extends JpaRepository<CrmCall, Long> {
    Optional<CrmCall> findByCrmId(String crmId);
}
