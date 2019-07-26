package com.qa.service;

import javax.inject.Inject;

import com.qa.persistence.repository.BookListRepository;

public class BookListService {

	@Inject
	private BookListRepository repo;

	public String createList(Long userId, String listsTodo) {
		return this.repo.createList(userId, listsTodo);
	}

	public String getAllLists() {
		return this.repo.getAllLists();
	}

	public String updateList(Long listId, String listsTodo) {
		return this.repo.updateList(listId, listsTodo);
	}

	public String deleteList(Long listId) {
		return this.repo.deleteList(listId);
	}
}