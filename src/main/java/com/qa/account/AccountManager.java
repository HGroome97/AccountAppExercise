package com.qa.account;

import java.util.HashMap;
import java.util.Map;

import com.qa.jsonobject.JsonObject;

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
	
	public String mapToJson(Map<Integer, Account> map) {
		JsonObject jo = new JsonObject();
		return jo.HashJsonString(map);
	}
	
}
