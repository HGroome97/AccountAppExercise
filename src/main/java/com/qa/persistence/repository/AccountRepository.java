package com.qa.persistence.repository;

import com.qa.persistence.domain.Account;

public interface AccountRepository {

	String getAllAccounts();
	String createAccount(String account);
	String getAccount(int id);
	String deleteAccount(int id);
	String updateAccount(Account acc);
}