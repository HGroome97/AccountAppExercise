package com.qa.business.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.qa.persistence.domain.Account;
import com.qa.util.JsonObject;

public class AccountManagerImpl {
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


	public int countNameOccurences(String name) {
		int count=0;
		Iterator it = this.accountMap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        Account acc = (Account) pair.getValue();
	        if(name == acc.getfName()) count++;
	        it.remove();
	    }	
	    return count;
	}
	
	public long countNameOccurencesStream(String name) {
		return accountMap.entrySet().stream().filter(n -> n.getValue().getfName()==name).count();
	}
	
		
}
