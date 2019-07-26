package com.qa.service;

public interface BookService {

	String getAllBooks();

	String createBook(String book);

	String deleteBook(int bookId);

	String updateBook(int bookId, String book); 

}
