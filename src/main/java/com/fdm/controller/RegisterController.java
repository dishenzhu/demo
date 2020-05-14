package com.fdm.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdm.dao.UserRepository;
import com.fdm.model.FormUser;
import com.fdm.model.User;
import com.fdm.service.UserService;

@Controller
public class RegisterController {

	static final String ERROR_URL = "register";
	static final String SUCCESS_URL = "redirect:/home";
	static final String ACTIVE_USER = "activeUser";
	static final String ERROR_MSG = "errorMessage";
	static final String USERNAME_EXISTS_MSG = "username exists";
	
	private UserService userService;

	@Autowired
	public RegisterController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping(value = "/getRegister")
	public String getRegisterPage(Model model, HttpSession session) {
		if (session.getAttribute(ACTIVE_USER) != null) {
			// redirect to controller with "/home" mapping 
			return SUCCESS_URL;
		}
		model.addAttribute("formUser", new FormUser());
		return ERROR_URL;
	}

	@PostMapping(value = "/processRegister")
	public String processRegister(HttpSession session, Model model, @Valid @ModelAttribute FormUser formUser,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ERROR_URL;
		}
		User registeredUser = userService.register(formUser);
		if (registeredUser == null) {
			model.addAttribute(ERROR_MSG, USERNAME_EXISTS_MSG);
			return ERROR_URL;
		}
		session.setAttribute(ACTIVE_USER, registeredUser);
		return SUCCESS_URL;
	}

}
