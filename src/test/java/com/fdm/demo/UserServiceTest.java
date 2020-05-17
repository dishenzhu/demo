package com.fdm.demo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.fdm.dao.UserRepository;
import com.fdm.model.FormUser;
import com.fdm.model.User;
import com.fdm.service.UserService;

public class UserServiceTest {

	@Mock
	UserRepository mockUserRepo;
	
	UserService userService;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		userService = new UserService(mockUserRepo);
	}
	
	@Test
	public void when_username_is_taken_return_null() {
		FormUser formUser = new FormUser("test", "123", "123@email");
		when(mockUserRepo.countByUsername(formUser.getUsername())).thenReturn(5L);
		User registeredUser = userService.register(formUser);
		verify(mockUserRepo).countByUsername(formUser.getUsername());
		assertNull(registeredUser);
	}
	
	@Test
	public void when_username_is_available_return_not_null_user() {
		FormUser formUser = new FormUser("test", "123", "123@email");
		User savedUser = new User(formUser);
		when(mockUserRepo.save(any(User.class))).thenReturn(savedUser);
		User registeredUser = userService.register(formUser);
		verify(mockUserRepo).countByUsername(formUser.getUsername());
		verify(mockUserRepo).save(any(User.class));
		assertNotNull(registeredUser);
		assertEquals(savedUser, registeredUser);
	}
	
}
