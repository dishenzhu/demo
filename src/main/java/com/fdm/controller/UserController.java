package com.fdm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fdm.dao.UserRepository;
import com.fdm.model.User;

@RestController
public class UserController {

	private UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@GetMapping("/getUser/{username}")
	public User getUser(@PathVariable String username) {
		Optional<User> opUser = userRepository.findByUsername(username);
		User user = null;
		if (opUser.isPresent()) {
			user = opUser.get();
			System.out.println("user.getUsername() = " + user.getUsername());
			System.out.println("user.getPassword() = " + user.getPassword());
		} else {
			System.out.println("user is not present");
		}
		return user;
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

}
