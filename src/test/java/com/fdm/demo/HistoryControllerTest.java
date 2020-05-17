package com.fdm.demo;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdm.controller.BookController;
import com.fdm.controller.HistoryController;
import com.fdm.dao.TransactionRepository;

public class HistoryControllerTest {
	
	@Mock
	TransactionRepository transactionRepository;
	@Mock
	HttpSession mockSession;
	
	HistoryController historyController;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		historyController = new HistoryController();
	}
	
	@Test(expected = NullPointerException.class)
	public void when_getHistory_returnhistoryPage() {
		String nextPage = historyController.getHistory(mockSession);
		assertEquals("history", nextPage);
	}

}
