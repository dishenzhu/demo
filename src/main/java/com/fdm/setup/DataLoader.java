package com.fdm.setup;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.fdm.dao.BookRepository;
import com.fdm.dao.TransactionRepository;
import com.fdm.dao.UserRepository;
import com.fdm.model.Book;
import com.fdm.model.FormUser;
import com.fdm.model.Transaction;
import com.fdm.model.User;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("adding data to db...");

	}

	
	
}
