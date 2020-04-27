package com.bookapp.service;

import java.util.ArrayList;
import java.util.Collections;import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.bean.Book;
import com.bookapp.dao.BookDAO;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO bookDAO;
	@Override
	public void addBook(Book book) {
		bookDAO.addBook(book);
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> bookList = bookDAO.getAllBooks();
		return bookList
				.stream()
				.sorted((book1,book2)->	book1.getAuthor().compareTo(book2.getAuthor()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Book> getBookByCategory(String category) {
		List<Book> bookList = bookDAO.getBookByCategory(category);
    	return bookList
				.stream()
				.sorted((book1,book2)->	book1.getAuthor().compareTo(book2.getAuthor()))
				.collect(Collectors.toList());	}

	@Override
	public Book getBookById(int bookid) {
		return bookDAO.getBookById(bookid);
	}

	@Override
	public void updateBook(Book book) {
		bookDAO.updateBook(book);
	}

	@Override
	public void deleteBook(int bookid) {
		bookDAO.deleteBook(bookid);
	}

}
