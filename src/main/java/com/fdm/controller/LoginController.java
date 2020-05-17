package com.fdm.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@DependsOn({"passwordEncoder"})
public class LoginController {
	
	static final String ERROR_MSG = "errorMessage";
	static final String INVALID_USERNAME_OR_PASSWORD_MSG = "Invalid username or password";
	static final String NO_USER_MSG = "username doesn't exist";
	
	private BCryptPasswordEncoder passwordEncoder;
	private UserRepository userRepository;

	@Autowired
	public LoginController( BCryptPasswordEncoder passwordEncoder, UserRepository userRepository) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
	}
	
	@GetMapping(value = "/login")
	public String getLoginPage(Model model, HttpSession session) {
		model.addAttribute("activeUser", new FormUser());
		return "login";
	}
	
	@PostMapping(value = "/processLogin")
	public String processRegister(HttpSession session, Model model, @Valid @ModelAttribute FormUser formUser,
			BindingResult bindingResult) {
		
		Optional<User> maybeuser = userRepository.findByUsername(formUser.getUsername());
		
		if(maybeuser.isPresent()) {
			User user = maybeuser.get();
			
			if (passwordEncoder.matches(formUser.getPassword(), user.getPassword())) {
				session.setAttribute("activeUser", user.getUsername());
				return "home";
			}
			
			else
				model.addAttribute("activeUser", new FormUser());
				model.addAttribute(ERROR_MSG, INVALID_USERNAME_OR_PASSWORD_MSG);
				return "login";
		}
		
		else 
			model.addAttribute("activeUser", new FormUser());
			model.addAttribute(ERROR_MSG, NO_USER_MSG);
			return "login";
	}
	
}
