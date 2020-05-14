package com.fdm.setup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.fdm.dao.UserRepository;
import com.fdm.model.FormUser;
import com.fdm.model.User;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("adding data to db...");
		userRepository.save(new User(new FormUser("matthew123", "password")));
	}

	
	
}
