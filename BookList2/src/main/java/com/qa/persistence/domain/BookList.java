package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BookList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long listId;
	private String listName;

	@ManyToOne
	private UserAccount user;

	public BookList(Long listId, String listName, UserAccount user) {
		super();
		this.listId = listId;
		this.listName = listName;
	}

	public BookList() {

	}

	public long getListId() {
		return listId;
	}

	public void setListId(Long listId) {
		this.listId = listId;
	}

	public String getListName() { 
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}
}
