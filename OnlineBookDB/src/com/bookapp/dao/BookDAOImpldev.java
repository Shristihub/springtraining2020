package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.bookapp.bean.Book;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;

public class BookDAOImpldev implements BookDAO {
	List<Book> bookList = new ArrayList<>();

	private static List<Book> showBookList() {

		List<Book> mybookList = Arrays.asList(new Book("Java", "Kathy", "Tech", 900),
				new Book("Java1", "Kathy", "Tech", 900),
				new Book("Java2", "Kathy", "Tech", 900), 
				new Book("Java3", "Kathy", "Tech", 900),
				new Book("Java4", "Kathy", "Tech", 900));
		return mybookList;
	}

	@Override
	public void addBook(Book book) {
		 bookList.add(book);
		 

	}

	@Override
	public boolean deleteBook(int bookid) throws BookNotFoundException {
		for (Book book : bookList) {
			if(book.getBookid()==bookid) {
				bookList.remove(book);
				return true;
			}
		}
		return false;
	}

	@Override
	public Book getBookById(int bookid) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBook(int bookid, int price) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookList;
	}

	@Override
	public List<Book> getBookbyAuthor(String author) throws AuthorNotFoundException {
		return bookList.stream()
		    .filter((Book book)-> book.getAuthor().equals(author))
			.collect(Collectors.toList());
				
	}

	@Override
	public List<Book> getBookbycategory(String category) throws CategoryNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
