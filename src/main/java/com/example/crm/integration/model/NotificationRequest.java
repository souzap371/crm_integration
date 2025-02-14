package com.example.crm.integration.model;


public class NotificationRequest {

    private String beneficiaryId;
    private String message;

    public NotificationRequest() {
    }

    public NotificationRequest(String beneficiaryId, String message) {
        this.beneficiaryId = beneficiaryId;
        this.message = message;
    }

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
