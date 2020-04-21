package com.bookapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bookapp.bean.Book;

@Repository
public class BookDAOImpl implements BookDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public void addBook(Book book) {
		String insertQuery = "insert into book values(?,?,?,?,?)";
		Object[] bookArray = {book.getTitle(),book.getBookid(),
				book.getAuthor(),book.getCategory(),book.getPrice()};
		jdbcTemplate.update(insertQuery, bookArray);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
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
		String updateQuery = "update book set price=? where bookid=?";
		Object[] bookArray = {book.getPrice(),book.getBookid()};
		jdbcTemplate.update(updateQuery,bookArray);
	}

	@Override
	public void deleteBook(int bookid) {
		String deleteQuery = "delete from book where bookid=?";
		jdbcTemplate.update(deleteQuery, bookid);
	}

}
