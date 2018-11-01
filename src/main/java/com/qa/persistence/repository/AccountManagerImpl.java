package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.business.service.AccountService;
import com.qa.persistence.domain.Account;
import com.qa.util.JsonObject;


@Alternative
public class AccountManagerImpl implements AccountRepository{
	
	
	private HashMap<Integer, Account> accountMap = new HashMap<>();

	public void addAccount(Account a) {
		accountMap.put(a.getAccountNumber(), a);
	}
	
	
	public Map<Integer, Account> getAccounts() {
		return accountMap;
	}
	
	public String deleteAccount(int accountNum) {
		accountMap.remove(accountNum);
		return "{\"message\": \"account sucessfully deleted\"}";
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


	@Override
	public String getAllAccounts() {
		return mapToJson(accountMap);
	}


	@Override
	public String createAccount(String account) {
		JsonObject jo = new JsonObject();
		Account acc = jo.JsonToObjectString(account);
		accountMap.put(acc.getAccountNumber(), acc);
		return "{\"message\": \"account has been sucessfully added\"}";
	}


	@Override
	public String getAccount(int id) {
		JsonObject jo = new JsonObject();
		return jo.ObjectJsonString(accountMap.get(id));
	}


	@Override
	public String updateAccount(Account acc) {
		accountMap.get(acc.getAccountNumber()).setfName(acc.getfName());
		accountMap.get(acc.getAccountNumber()).setlName(acc.getlName());
		return "{\"message\": \"account has been sucessfully updated\"}";
	}




		
}
