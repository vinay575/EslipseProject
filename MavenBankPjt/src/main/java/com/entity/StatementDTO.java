package com.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private Timestamp transactionDate;
	
	




	public StatementDTO() {
		super();
		// TODO Auto-generated constructor stub
	}




	public StatementDTO(int fromAccountNumber, int toAccountNumber, double amount, Timestamp transactionDate
			) {
		super();
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.amount = amount;
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

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	

}