package com.fdm.demo;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.fdm.controller.HistoryController;
import com.fdm.controller.HomeController;
import com.fdm.dao.TransactionRepository;

public class HomeControllerTest {

	@Mock
	Model mockModel;
	HomeController homeController;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		homeController = new HomeController();
	}
	
	@Test
	public void when_getHome_returnhomePage() {
		String nextPage = homeController.getHome();
		assertEquals("home", nextPage);
	}
	
	@Test
	public void when_getSeller_returnSellerPage() {
		String nextPage = homeController.getSeller(mockModel);
		assertEquals("seller", nextPage);
	}
	
	@Test
	public void when_getBuyer_returnBuyerPage() {
		String nextPage = homeController.getBuyer(mockModel);
		assertEquals("buyer", nextPage);
	}
	
}
