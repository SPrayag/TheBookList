package com.qa.service;

import javax.inject.Inject;

import com.qa.exceptions.AccountNotFoundException;
import com.qa.persistence.repository.UserAccountRepository;

public class UserAccountServiceImpl implements UserAccountService {
	@Inject
	private UserAccountRepository repo;

	@Override
	public String getAllAccounts() {
		return this.repo.getAllAccounts();
	}

	@Override
	public String createAccount(String account) {
		return this.repo.createAccount(account);
	}

	@Override
	public String deleteAccount(int accountId) throws AccountNotFoundException {
		return this.repo.deleteAccount(accountId);
	}

	@Override
	public String updateAccount(int accountId, String account) throws AccountNotFoundException {
		return this.repo.updateAccount(accountId, account);
	}

}
