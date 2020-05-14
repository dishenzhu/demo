package com.fdm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fdm.dao.UserRepository;
import com.fdm.model.Book;
import com.fdm.model.FormUser;
import com.fdm.model.User;

@Controller
public class BookController {
	
	@GetMapping("/getBooks")
	public String getProductsPage(HttpSession session) {
		List<Book> books = new ArrayList<>();
		session.setAttribute("allBooks", books);
		return "Books";
	}
	
	
	
}
