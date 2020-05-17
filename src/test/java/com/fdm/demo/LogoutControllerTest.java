package com.fdm.demo;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import com.fdm.controller.LoginController;
import com.fdm.controller.LogoutController;
import com.fdm.dao.UserRepository;

public class LogoutControllerTest {

	@Mock
	HttpSession mockSession;
	@Mock
	Model mockModel;
	
	
	LogoutController logoutController;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		logoutController = new LogoutController();
	}
	
	@Test
	public void when_getLoginPage_returnloginPage() {
		String nextPage = logoutController.getLogoutPage(mockModel, mockSession);
		assertEquals("logout", nextPage);
	}
}
