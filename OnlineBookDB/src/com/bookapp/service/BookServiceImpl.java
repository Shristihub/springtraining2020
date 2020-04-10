package com.bookapp.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.bookapp.bean.Book;
import com.bookapp.dao.BookDAO;
import com.bookapp.dao.BookDAOImpl;
import com.bookapp.dao.BookDAOImpldev;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;

public class BookServiceImpl implements BookService{

	BookDAO bookDAO = new BookDAOImpldev();
	
	@Override
	public void addBook(Book book) {
		bookDAO.addBook(book);
	}
	@Override
	public boolean deleteBook(int bookid) throws BookNotFoundException {
		boolean deleteBook =bookDAO.deleteBook(bookid); 
		if(!deleteBook)
			throw new BookNotFoundException("Invalid Id");
		return true;
	}
	@Override
	public Book getBookById(int bookid) throws BookNotFoundException {
		Book book = bookDAO.getBookById(bookid);
		if(book == null) {
			throw new BookNotFoundException("Invalid Id");
		}
		return book;
	}

	@Override
	public boolean updateBook(int bookid, int price) {
		
		return bookDAO.updateBook(bookid, price);
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> bookList = bookDAO.getAllBooks()
		.stream()
		.sorted((book1,book2)->{
	return book1.getTitle().compareTo(book2.getTitle());
			}
		)
		.collect(Collectors.toList());			
		return bookList;
	}

	@Override
	public List<Book> getBookbyAuthor(String author) throws AuthorNotFoundException {
		List<Book> bookList = bookDAO.getBookbyAuthor(author);
		if(bookList.isEmpty()) {
			throw new AuthorNotFoundException("Author not available");
		} 
		return bookList;
	}

	@Override
	public List<Book> getBookbycategory(String category) throws CategoryNotFoundException {
		List<Book> bookList = bookDAO
				.getAllBooks()
				.stream()
				.sorted((book1,book2)->{
			return book1.getTitle().compareTo(book2.getTitle());
					}
				)
				.collect(Collectors.toList());
		return bookList;
	}

	
	

}
