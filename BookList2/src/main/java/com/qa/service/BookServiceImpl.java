package com.qa.service;

import javax.inject.Inject;

import com.qa.exceptions.AccountNotFoundException;
import com.qa.persistence.repository.BookRepository; 

public class BookServiceImpl implements BookService { 
	@Inject
	private BookRepository repo; 
 
	@Override
	public String getAllBooks() {
		return this.repo.getAllBooks();
	}

	@Override
	public String createBook(String book) {
		return this.repo.createBook(book);
	}

	@Override
	public String deleteBook(int bookId) throws AccountNotFoundException {
		return this.repo.deleteBook(bookId);
	}

	@Override
	public String updateBook(int bookId, String book) throws AccountNotFoundException {
		return this.repo.updateBook(bookId, book); 
	}

}
