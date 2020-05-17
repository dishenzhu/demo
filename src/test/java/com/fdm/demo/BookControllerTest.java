package com.fdm.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.fdm.controller.BookController;
import com.fdm.controller.RegisterController;
import com.fdm.dao.BookRepository;
import com.fdm.dao.TransactionRepository;
import com.fdm.dao.UserRepository;
import com.fdm.model.FormUser;
import com.fdm.model.Book;

public class BookControllerTest {

	@Mock
	UserRepository userRepository;
	@Mock
	BookRepository bookRepository;
	@Mock
	TransactionRepository transactionRepository;
	@Mock
	Model mockModel;
	@Mock
	HttpSession mockSession;
	@Mock
	List<Book> mockBooks;
	@Mock
	Book mockBook;
	
	BookController bookController;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		bookController = new BookController(bookRepository, userRepository, transactionRepository);
	}

	@Test
	public void when_getBooks_returnBooksPage() {
		String nextPage = bookController.getBooksPage(mockSession);
		assertEquals("Books", nextPage);
	}
	
	@Test(expected = NullPointerException.class) 
	public void when_postProcessSelling_returnHomePage() {
		String nextPage = bookController.addBook(mockSession, mockModel, null);
		assertEquals("home", nextPage);
	}
	
	@Test(expected = NullPointerException.class) 
	public void when_postProcessBuying_returnHomePage() {
		String nextPage = bookController.buyBook(mockSession, mockModel, (Integer) null);
		assertEquals("Books", nextPage);
	}
	
	@Test
	public void when_postProcessSearch_returnFoundbooksPage() {
		String nextPage = bookController.searchBook(mockSession, null);
		assertEquals("foundbooks", nextPage);
	}
}
