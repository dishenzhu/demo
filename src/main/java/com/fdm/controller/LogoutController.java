package com.fdm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
	
	@GetMapping(value = "/logout")
	public String getLogoutPage(Model model, HttpSession session) {
		session.setAttribute("activeUser", null);
		return "logout";
	}
}
