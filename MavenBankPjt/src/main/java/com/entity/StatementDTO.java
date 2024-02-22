package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Statement")
public class StatementDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;

	@Column
	private int fromAccountNumber;

	@Column
	private int toAccountNumber;

	@Column
	private double amount;

	@Column
	private String transactionType;

	@Column(name = "transactionDate", columnDefinition = "DATE")
	    private Date transactionDate;
	
	
	




	public StatementDTO() {
		super();
		// TODO Auto-generated constructor stub
	}




	public StatementDTO(int fromAccountNumber, int toAccountNumber, double amount, String transactionType, Date transactionDate) {
	    super();
	    this.fromAccountNumber = fromAccountNumber;
	    this.toAccountNumber = toAccountNumber;
	    this.amount = amount;
	    this.transactionType = transactionType;
	    this.transactionDate = transactionDate;
	}




	public int getTransactionId() {
		return transactionId;
	}




	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}




	public int getFromAccountNumber() {
		return fromAccountNumber;
	}




	public void setFromAccountNumber(int fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}




	public int getToAccountNumber() {
		return toAccountNumber;
	}




	public void setToAccountNumber(int toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}




	public double getAmount() {
		return amount;
	}




	public void setAmount(double amount) {
		this.amount = amount;
	}




	public String getTransactionType() {
		return transactionType;
	}




	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}




	public Date getTransactionDate() {
		return transactionDate;
	}




	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}





}