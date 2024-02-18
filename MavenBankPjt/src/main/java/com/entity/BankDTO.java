package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "bank_Account")
public class BankDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "accountID")
    private int accountID;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDTO user;

    @Column(name = "bankAccountNo")
    private String bankAccountNo;

    @Column(name = "bankName")
    private String bankName;

    @Column(name = "ifscCode")
    private String ifscCode;

    @Column(name = "accountType")
    private String accountType;

    @Column(name = "currentBalance")
    private double currentBalance;
    
    
    

    public BankDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankDTO(UserDTO user, String bankAccountNo, String bankName, String ifscCode, String accountType, double currentBalance) {
        this.user = user;
        this.bankAccountNo = bankAccountNo;
        this.bankName = bankName;
        this.ifscCode = ifscCode;
        this.accountType = accountType;
        this.currentBalance = currentBalance;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
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