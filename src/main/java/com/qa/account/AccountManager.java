package com.qa.account;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {
	private HashMap<Integer, Account> accountMap = new HashMap<>();

	public void addAccount(Account a) {
		accountMap.put(a.getAccountNumber(), a);
	}
	
	
	public Map<Integer, Account> getAccounts() {
		return accountMap;
	}
	
	public void deleteAccount(int accountNum) {
		accountMap.remove(accountNum);
	}
	
}
