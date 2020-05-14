package com.fdm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fdm.model.Book;

@Controller
public class BookController {
	
	@GetMapping("/getBooks")
	public String getProductsPage(HttpSession session) {
		List<Book> books = new ArrayList<>();
		books.add(new Book("Harry Potter", 34.99));
		session.setAttribute("allBooks", books);
		return "Books";
	}
	
	
	
}
