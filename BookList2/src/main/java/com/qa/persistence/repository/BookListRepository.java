package com.qa.persistence.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistence.domain.BookList;
import com.qa.persistence.domain.UserAccount;
import com.qa.util.JSONUtil;

@Transactional(value = TxType.REQUIRED)
public class BookListRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil json;

	@Transactional(value = TxType.REQUIRED)
	public String createList(Long userId, String listsTodo) {
		UserAccount listOwner = this.em.find(UserAccount.class, userId);
		BookList newList = this.json.getObjectForJSON(listsTodo, BookList.class);
		newList.setUser(listOwner);
		this.em.persist(newList);

		return "Success for: " + this.json.getObjectForJSON(listsTodo, BookList.class).getListName();
	}

	public String getAllLists() {
		TypedQuery<BookList> query = this.em.createQuery("SELECT 1 FROM ListsTodo 1", BookList.class);
		return this.json.getJSONForObject(query.getResultList());
	}

	@Transactional(value = TxType.REQUIRED)
	public String updateList(Long listId, String listsTodo) {
		BookList current = this.em.find(BookList.class, listId);
		BookList newList = this.json.getObjectForJSON(listsTodo, BookList.class);
		current.setListName(newList.getListName());

		this.em.persist(current);
		return "Success for: " + current.getListName();
	}

	@Transactional(value = TxType.REQUIRED)
	public String deleteList(Long listId) {
		this.em.remove(this.em.find(BookList.class, listId));
		return "Deleted List";
	}
}
