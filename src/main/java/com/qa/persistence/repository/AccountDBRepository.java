package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JsonObject;

@Transactional(SUPPORTS)

public class AccountDBRepository implements AccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JsonObject jsonOb;
	
	public String getAllAccounts() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return jsonOb.ObjectJsonString(accounts);
	}
	
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account anAccount = jsonOb.JsonToObjectString(account);
		manager.persist(anAccount);
		return "{\"message\": \"account has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteAccount(int id) {
		Account accountInDB = findAccount(id);
		if (accountInDB != null) {
			manager.remove(accountInDB);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}

	public String getAccount(int id) {
		Account accountInDB = findAccount(id);
		return jsonOb.ObjectJsonString(accountInDB);
	}
	
	@Transactional(REQUIRED)
	public String updateAccount(int accountNum, String fName, String lName) {
		//int query = manager.createQuery("UPDATE a FROM Account a SET fName = "+fName+", lName = "+lName+ " WHERE accountnumber = "+accountNum).executeUpdate();
		Account accountInDB = findAccount(accountNum);
		accountInDB.setfName(fName);
		accountInDB.setlName(lName);
		return "{\"message\": \"account has been sucessfully updated\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateAccount(Account acc) {
		//int query = manager.createQuery("UPDATE a FROM Account a SET fName = "+fName+", lName = "+lName+ " WHERE accountnumber = "+accountNum).executeUpdate();
		Account accountInDB = findAccount(acc.getAccountNumber());
		accountInDB.setfName(accountInDB.getfName());
		accountInDB.setlName(accountInDB.getlName());
		return "{\"message\": \"account has been sucessfully updated\"}";
	}
	
	
	private Account findAccount(int id) {
		return manager.find(Account.class, id);
	}


	public void setManager(EntityManager manager) {
		this.manager = manager;
	}


		
}
