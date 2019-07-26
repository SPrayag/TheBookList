package com.qa.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.qa.exceptions.AccountNotFoundException;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistence.domain.UserAccount;
import com.qa.util.JSONUtil;
  
@Transactional(value = TxType.SUPPORTS)
@Default
public class UserAccountDBRepository implements UserAccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em; 

	@Inject
	private JSONUtil json;

	@Override
	public String getAllAccounts() {
		TypedQuery<UserAccount> query = this.em.createQuery("SELECT a from UserAccount a", UserAccount.class);
		return this.json.getJSONForObject(query.getResultList());
	} 

	@Override
	@Transactional(value = TxType.REQUIRED)
	public String createAccount(String account) {
		UserAccount toCreate = this.json.getObjectForJSON(account, UserAccount.class);
		this.em.persist(toCreate);
		return SUCCESS;
	} 

	@Override
	@Transactional(value = TxType.REQUIRED)
	public String deleteAccount(int accountId) throws AccountNotFoundException {
		this.em.remove(this.em.find(UserAccount.class, accountId));
		return SUCCESS;
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public String updateAccount(int accountId, String account) throws AccountNotFoundException {
		UserAccount newAccount = this.json.getObjectForJSON(account, UserAccount.class);
		UserAccount existing = this.em.find(UserAccount.class, accountId);
		if (existing == null) {
			throw new AccountNotFoundException();
		}
		existing.setId(newAccount.getAccountId());
		existing.setFirstName(newAccount.getFirstName());
		existing.setLastName(newAccount.getLastName()); 
		existing.setUsername(newAccount.getUsername());
		existing.setPassword(newAccount.getPassword());
		existing.setEmail(newAccount.getEmail());
		this.em.persist(existing);
		return SUCCESS;
	}
}
