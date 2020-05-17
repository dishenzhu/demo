package com.fdm.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdm.dao.TransactionRepository;
import com.fdm.dao.UserRepository;
import com.fdm.model.Book;
import com.fdm.model.FormUser;
import com.fdm.model.Transaction;
import com.fdm.model.User;

@Controller
public class HistoryController {
	@Autowired
	private TransactionRepository transactionRepository;
	
	
	@GetMapping("/history")
	public String getHistory(HttpSession session) {
		String activeUser = (String) session.getAttribute("activeUser");
		List<Transaction> transactions = transactionRepository.findByBuyer_Username(activeUser);
		session.setAttribute("history", transactions);
		return "history";
	}
	
	
	
	
}
