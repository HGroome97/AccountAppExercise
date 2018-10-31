package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Account {
	
	private String fName;
	private String lName;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Size(min = 6, max = 6)
	private int accountNumber;
	
	public Account(String fName, String lName, int accountNumber) {
		this.fName = fName;
		this.lName = lName;
		this.accountNumber = accountNumber;
	}

	public Account(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Account [fName=" + fName + ", lName=" + lName + ", accountNumber=" + accountNumber + "]";
	}
}
