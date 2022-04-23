package com.model;

import java.sql.Date;

public class Customer {
	int AccountNumber;
	String AccountName;
	  float OpeningBalance;
	String AccountOpenedBranch;
	String AccountType;
	float currentbalance;
	
	
	
	public float getCurrentbalance() {
		return currentbalance;
	}
	public void setCurrentbalance(float currentbalance) {
		this.currentbalance = currentbalance;
	}
	public int getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	public float getOpeningBalance() {
		return OpeningBalance;
	}
	public void setOpeningBalance(float openingBalance) {
		this.OpeningBalance = openingBalance;
	}
	public String getAccountOpenedBranch() {
		return AccountOpenedBranch;
	}
	public void setAccountOpenedBranch(String accountOpenedBranch) {
		AccountOpenedBranch = accountOpenedBranch;
	}
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String accountType) {
		AccountType = accountType;
	}
	
}
