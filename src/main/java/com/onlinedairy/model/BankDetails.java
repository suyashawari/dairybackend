package com.onlinedairy.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
public class BankDetails {
    private String accountHolder;
    private String accountNumber;
    private String ifscCode;

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }
}
