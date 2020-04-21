package com.bookapp.service;

import java.util.List;

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
		return null;
	}

	@Override
	public List<Book> getBookByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBookById(int bookid) {
		// TODO Auto-generated method stub
		return null;
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
