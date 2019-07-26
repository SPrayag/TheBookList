package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.service.BookService; 

@Path("/book")
public class BookController {

	@Inject
	private BookService service; 

	@GET
	@Path("/getAll")
	public String getAllBooks() {
		return this.service.getAllBooks();
	}

	@POST
	@Path("/createBooks")
	public String createBooks(String book) {
		return this.service.createBook(book);
	}

	@DELETE
	@Path("/delete/{id}")
	public String deleteBook(@PathParam("id") int bookId) {
		return this.service.deleteBook(bookId); 
	}

	@POST
	@Path("/update/{id}")
	public String updateBook(@PathParam("id") int bookId, String book) {
		return this.service.updateBook(bookId, book); 
	}

}
