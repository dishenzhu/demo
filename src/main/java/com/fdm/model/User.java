package com.fdm.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fdm.model.FormUser;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String email;
	@JsonIgnore
	private String password;
	@OneToMany(fetch=FetchType.EAGER, mappedBy="seller")
	List<Book> books = new ArrayList<>();
	@OneToMany( mappedBy="buyer")
	List<Transaction> history=new ArrayList<>();

	public List<Transaction> getHistory() {
		return history;
	}

	public void setHistory(List<Transaction> history) {
		this.history = history;
	}

	public User() {
		super();
	}

	public User(FormUser formUser) {
		this.username = formUser.getUsername();
		this.password = formUser.getPassword();
		this.email = formUser.getEmail();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void add(Book book) {		
		books.add(book);
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public void add(Transaction transaction) {
		history.add(transaction);
	}

}