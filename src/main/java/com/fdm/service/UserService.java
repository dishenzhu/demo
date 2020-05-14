package com.fdm.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdm.dao.UserRepository;
import com.fdm.model.FormUser;
import com.fdm.model.User;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public User register(FormUser formUser) {
		if (userRepository.countByUsername(formUser.getUsername()) != 0) {
			return null;
		}
		User user = new User(formUser);
		return userRepository.save(user);
	}

}