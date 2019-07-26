package com.qa.persistence.repository;

import com.qa.exceptions.AccountNotFoundException;

public interface UserAccountRepository {

	final String SUCCESS = "Operation Succeeded";
	final String FAILURE = "Operation Failed";

	String getAllAccounts();

	String createAccount(String account);

	String deleteAccount(int accoundId) throws AccountNotFoundException;

	String updateAccount(int accountId, String account) throws AccountNotFoundException;
}
