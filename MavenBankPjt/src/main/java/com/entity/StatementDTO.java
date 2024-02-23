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
	private int from_Account_Id;

	@Column
	private int to_Account_Id;

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




	public StatementDTO(int from_Account_Id, int to_Account_Id, double amount, String transactionType, Date transactionDate) {
	    super();
	    this.from_Account_Id = from_Account_Id;
	    this.to_Account_Id = to_Account_Id;
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




	public int getFrom_Account_Id() {
		return from_Account_Id;
	}




	public void setFrom_Account_Id(int from_Account_Id) {
		this.from_Account_Id = from_Account_Id;
	}




	public int getTo_Account_Id() {
		return to_Account_Id;
	}




	public void setTo_Account_Id(int to_Account_Id) {
		this.to_Account_Id = to_Account_Id;
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