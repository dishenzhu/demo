package com.fdm.demo;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import com.fdm.controller.HistoryController;
import com.fdm.controller.LoginController;
import com.fdm.dao.TransactionRepository;
import com.fdm.dao.UserRepository;

public class LoginControllerTest {
	
	@Mock
	UserRepository userRepository;
	@Mock
	HttpSession mockSession;
	@Mock
	Model mockModel;
	
	BCryptPasswordEncoder passwordEncoder;
	LoginController loginController;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		loginController = new LoginController(passwordEncoder, userRepository);
	}
	
	@Test
	public void when_getLoginPage_returnloginPage() {
		String nextPage = loginController.getLoginPage(mockModel, mockSession);
		assertEquals("login", nextPage);
	}

}
