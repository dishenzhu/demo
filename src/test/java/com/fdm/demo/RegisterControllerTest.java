package com.fdm.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.fdm.controller.RegisterController;
import com.fdm.model.FormUser;
import com.fdm.model.User;
import com.fdm.service.UserService;

public class RegisterControllerTest {

	@Mock
	UserService mockUserService;
	@Mock
	Model mockModel;
	@Mock
	HttpSession mockSession;
	@Mock
	User mockUser;
	@Mock
	FormUser mockFormUser;
	@Mock
	BindingResult mockBindingResult;

	RegisterController registerController;
	BCryptPasswordEncoder passwordEncoder;
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		registerController = new RegisterController(mockUserService, passwordEncoder);
	}

	@Test
	public void when_getRegister_forRegister_with_noActiveSession_thenReturnRegisterPage() {
		String nextPage = registerController.getRegisterPage(mockModel, mockSession);
		verify(mockSession).getAttribute(RegisterController.ACTIVE_USER);
		verify(mockModel).addAttribute(eq("formUser"), any(FormUser.class));
		assertEquals(RegisterController.ERROR_URL, nextPage);
	}

	@Test
	public void when_getRegister_forRegister_with_activeSession_thenReturnRedirectHome(){
		when(mockSession.getAttribute(RegisterController.ACTIVE_USER)).thenReturn(mockUser);
		String nextPage = registerController.getRegisterPage(mockModel, mockSession);
		verify(mockSession).getAttribute(RegisterController.ACTIVE_USER);
		assertEquals(RegisterController.SUCCESS_URL, nextPage);
	}

	@Test
	public void when_postRequest_forRegister_with_formErrors_thenReturnRegisterPage() {
		when(mockBindingResult.hasErrors()).thenReturn(true);
		String nextPage = registerController.processRegister(mockSession, mockModel, mockFormUser, mockBindingResult);
		verify(mockBindingResult).hasErrors();
		assertEquals(RegisterController.ERROR_URL, nextPage);
	}

	@Test(expected = NullPointerException.class)  
	public void when_postRequest_forRegister_with_invalidUsername_thenReturnRegisterPage() {
		String nextPage = registerController.processRegister(mockSession, mockModel, mockFormUser, mockBindingResult);
		verify(mockBindingResult).hasErrors();
		verify(mockUserService).register(mockFormUser);
		verify(mockModel).addAttribute(RegisterController.ERROR_MSG, RegisterController.USERNAME_OR_EMAIL_EXISTS_MSG);
		assertEquals(RegisterController.ERROR_URL, nextPage);
	}
	
	@Test(expected = NullPointerException.class)  
	public void when_postRequest_forRegister_with_validUsername_thenReturnRedirectHome() {
		when(mockUserService.register(mockFormUser)).thenReturn(mockUser);
		String nextPage = registerController.processRegister(mockSession, mockModel, mockFormUser, mockBindingResult);
		verify(mockBindingResult).hasErrors();
		verify(mockUserService).register(mockFormUser);
		verify(mockSession).setAttribute(RegisterController.ACTIVE_USER, mockUser);
		assertEquals(RegisterController.SUCCESS_URL, nextPage);
	}

}
