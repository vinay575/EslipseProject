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
	private double amount;

	@Column
	private int fromAccountNumber;

	@Column
	private int toAccountNumber;

	@Column
	private Timestamp transactionDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountID", insertable = false, updatable = false)
	private BankDTO bank;

	public StatementDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatementDTO(int transactionId,  double amount, int fromAccountNumber,
			int toAccountNumber, Timestamp transactionDate, BankDTO bank) {
		super();
		this.transactionId = transactionId;		
		this.amount = amount;
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.transactionDate = transactionDate;
		this.bank = bank;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BankDTO getBank() {
		return bank;
	}

	public void setBank(BankDTO bank) {
		this.bank = bank;
	}

}