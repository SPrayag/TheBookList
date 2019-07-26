package com.qa.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.exceptions.AccountNotFoundException;
import com.qa.persistence.domain.Book;
import com.qa.util.JSONUtil; 

@Transactional(value = TxType.SUPPORTS)
@Default
public class BookDBRepository implements BookRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil json;

	@Override
	public String getAllBooks() {
		TypedQuery<Book> query = this.em.createQuery("SELECT b from Book b", Book.class);
		return this.json.getJSONForObject(query.getResultList());
	} 
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public String createBook(String book) {
		Book toCreate = this.json.getObjectForJSON(book, Book.class);
		this.em.persist(toCreate);
		return SUCCESS; 
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public String deleteBook(int bookId) throws AccountNotFoundException {
		this.em.remove(this.em.find(Book.class, bookId));
		return SUCCESS; 
	}
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public String updateBook(int bookId, String book) throws AccountNotFoundException {
		Book newBook = this.json.getObjectForJSON(book, Book.class);
		Book existing = this.em.find(Book.class, bookId);
		if (existing == null) {
			throw new AccountNotFoundException();
		}
		existing.setBookId(newBook.getBookId());
		existing.setBookTitle(newBook.getBookTitle());
		existing.setBookAuthor(newBook.getBookAuthor()); 		
		this.em.persist(existing);
		return SUCCESS;
	}
	
	
}
