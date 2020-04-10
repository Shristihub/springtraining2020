package com.bookapp.service;

import java.util.List;

import com.bookapp.dao.BookDAO;
import com.bookapp.dao.BookDAOImpl;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImpl implements BookService {
	
	BookDAO bookDAO = new BookDAOImpl();

	public void addBook(Book book) {
		bookDAO.addBook(book);
		
	}

	public boolean deleteBook(int bookid) throws BookNotFoundException {
		boolean result = true;
			if(result) {
				System.out.println("Exception occured");
				throw new BookNotFoundException("Invalid id");
		   }
		return result;
	}

	public Book getBookById(int bookid) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateBook(int bookid, int price) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Book> getAllBooks() {
		return bookDAO.getAllBooks();
	}

	public List<Book> getBookbyAuthor(String author) throws AuthorNotFoundException {
		return bookDAO.getBookbyAuthor(author);
	}

	public List<Book> getBookbycategory(String category) throws CategoryNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
