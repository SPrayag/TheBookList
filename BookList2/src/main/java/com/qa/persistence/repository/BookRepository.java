package com.qa.persistence.repository;

import com.qa.exceptions.AccountNotFoundException;

public interface BookRepository {

	final String SUCCESS = "Operation Succeeded";
	final String FAILURE = "Operation Failed";

	String getAllBooks();

	String createBook(String book);

	String deleteBook(int bookId) throws AccountNotFoundException;

	String updateBook(int bookId, String book) throws AccountNotFoundException;

}
