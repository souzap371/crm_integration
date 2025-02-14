package com.example.crm.integration.dto;


public class NotificationRequestDto {
    private String beneficiaryId;
    private String message;

    // Getters e Setters

    public String getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(String beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
