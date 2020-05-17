package com.fdm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdm.dao.BookRepository;
import com.fdm.model.Book;

@Service
public class BookService {

	private BookRepository bookRepository;

	@Autowired
	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}
	
	public Book addBook(Book book) {
		
		return bookRepository.save(book);
	}
	

	
	
	
	
	
	
}
