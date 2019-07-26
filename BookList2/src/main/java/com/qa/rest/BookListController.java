package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.service.BookListService;

@Path("/lists")
public class BookListController {

	@Inject
	private BookListService service;

	@GET
	@Path("/getAll")
	public String getAllLists() {
		return this.service.getAllLists();
	}

	@POST
	@Path("/create/{userId}")
	public String createList(@PathParam("userId") Long userId, String listsTodo) {
		return this.service.createList(userId, listsTodo);
	}

	@DELETE
	@Path("/delete/{listId}")
	public String deleteList(@PathParam("listId") Long listId) {
		return this.service.deleteList(listId);
	}

	@POST
	@Path("/update/{listId}")
	public String updateList(@PathParam("listId") Long listId, String listsTodo) {
		return this.service.updateList(listId, listsTodo);
	}

}
