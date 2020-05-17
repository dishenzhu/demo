package com.fdm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fdm.model.Book;
import com.fdm.model.FormUser;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	
	@GetMapping("/seller")
	public String getSeller(Model model) {
		model.addAttribute("book", new Book());
		return "seller";
	}
	
	@GetMapping("/buyer")
	public String getBuyer(Model model) {
		model.addAttribute("book", new Book());
		return "buyer";
	}
	
}