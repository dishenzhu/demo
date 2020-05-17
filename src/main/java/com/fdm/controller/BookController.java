package com.fdm.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdm.dao.BookRepository;
import com.fdm.dao.TransactionRepository;
import com.fdm.dao.UserRepository;
import com.fdm.model.Book;
import com.fdm.model.FormUser;
import com.fdm.model.Transaction;
import com.fdm.model.User;

@Controller
public class BookController {
	
	 private BookRepository bookRepository ;
	 private UserRepository userRepository ;
	 private TransactionRepository transactionRepository;
	
	@Autowired
	public BookController(BookRepository bookRepository, UserRepository userRepository, TransactionRepository transactionRepository) {
		super();
		this.bookRepository = bookRepository;
		this.userRepository = userRepository;
		this.transactionRepository = transactionRepository;
	}
	
	@GetMapping("/Books")
	public String getBooksPage(HttpSession session) {
		
		List<Book> books = (List<Book>) bookRepository.findByForSaleTrueAndSeller_UsernameNot((String) session.getAttribute("activeUser"));
		session.setAttribute("allBooks", books);
		return "Books";
	}
	
	@PostMapping("/processSelling")
	public String addBook(HttpSession session, Model model,@ModelAttribute Book book) {
		
		System.out.println(book.getName());
		
		String username = (String) session.getAttribute("activeUser");
		User activeUser = userRepository.findByUsername(username).get();
		book.setSeller(activeUser);
		activeUser.add(book);
		bookRepository.save(book);
		userRepository.save(activeUser);
		model.addAttribute("message", "You have already added this book for selling");
		return "home";
	}
	
	@PostMapping("/processBuying")
	@Transactional
	public String buyBook(HttpSession session, Model model, @RequestParam int bookId) {
		
		System.out.println(bookId);
		String activeUsername = (String) session.getAttribute("activeUser");
		Optional<Book> opBook = bookRepository.findById((long) bookId);
		Book book = opBook.get();
		book.setForSale(false);
		User activeUser = userRepository.findByUsername(activeUsername).get();
		Transaction transaction = new Transaction(activeUser, book);
		transactionRepository.save(transaction);
		activeUser.add(transaction);
		bookRepository.save(book);
		userRepository.save(activeUser);
		model.addAttribute("message", "You have already purchased this book");
		return "home";
	}
	
	@PostMapping("/processSearch")
	public String searchBook(HttpSession session, @RequestParam String bookname) {
		
		List<Book> foundBook = bookRepository.findByForSaleTrueAndName(bookname);
		session.setAttribute("foundBook", foundBook);
		return "foundbooks";	
	}

}
