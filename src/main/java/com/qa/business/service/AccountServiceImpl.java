package com.qa.business.service;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;


@Default
public class AccountServiceImpl implements AccountService {

	@Inject
	private AccountRepository repo;

	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	@Override
	public String addAccount(String account) {
		return repo.createAccount(account);
	}

	@Override
	public String deleteAccount(int id) {
		return repo.deleteAccount(id);
	}

	@Override
	public String getAccount(int id) {
		return repo.getAccount(id);
	}

	@Override
	public String updateAccount(Account acc) {
		return repo.updateAccount(acc);
	}

	
	public void setRepo(AccountRepository repo) {
		this.repo = repo;
	}

	
}
