package com.bookapp.dao;

import java.util.List;

import com.bookapp.bean.Book;

public interface BookDAO {

	void addBook(Book book);
	List<Book> getAllBooks();
	List<Book>  getBookByCategory(String category);
	Book getBookById(int bookid);
	void updateBook(Book book);
	void deleteBook(int bookid);
}
