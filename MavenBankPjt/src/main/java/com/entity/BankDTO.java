package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank_Account")
public class BankDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountID;
    
    @Column
    private int userId;
    
    @Column
    private String bankAccountNo;
    
    @Column
    private String bankName;
    
    @Column
    private String ifscCode;
    
    @Column
    private String accountType;
    
    @Column
    private double currentBalance;
    
    public BankDTO() {
        // Default constructor
    }
    
    public BankDTO(int userId, String bankAccountNo, String bankName, String ifscCode, String accountType, double currentBalance) {
        this.userId = userId;
        this.bankAccountNo = bankAccountNo;
        this.bankName = bankName;
        this.ifscCode = ifscCode;
        this.accountType = accountType;
        this.currentBalance = currentBalance;
    }
    
    // Getters and Setters
    
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
}
