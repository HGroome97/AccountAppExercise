package com.qa.account;

import java.util.HashMap;

public class AccountManager {
	private HashMap<Integer, Account> accountMap = new HashMap<Integer, Account>();

	public void addAccount(Account a) {
		accountMap.put(a.getAccountNumber(), a);
	}
	
	
	public HashMap<Integer, Account> getAccounts() {
		return accountMap;
	}

}
