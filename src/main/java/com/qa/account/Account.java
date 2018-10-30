package com.qa.account;

public class Account {
	private String fName;
	private String lName;
	private int accountNumber;
	
	public Account(String fName, String lName, int accountNumber) {
		this.fName = fName;
		this.lName = lName;
		this.accountNumber = accountNumber;
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
