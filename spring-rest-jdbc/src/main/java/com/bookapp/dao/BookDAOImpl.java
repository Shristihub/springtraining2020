package com.bookapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
		String query = "select * from book";
		List<Book> bookList = jdbcTemplate.query(query, new RowMapper<Book>() {

			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				Book book  = new Book();
				String title = rs.getString("title");
				book.setTitle(title);
				book.setBookid(rs.getInt("bookid"));
				book.setAuthor(rs.getString("author"));
				book.setCategory(rs.getString("category"));
				book.setPrice(rs.getInt("price"));
				return book;
			}
			
		});
		return bookList;
	}

	@Override
	public List<Book> getBookByCategory(String category) {
		String query = "select * from book where category=?";
		List<Book> bookList = jdbcTemplate.query(query,new Object[] {category},
			(rs, rowNum) -> {
				Book book  = new Book();
				String title = rs.getString("title");
				book.setTitle(title);
				book.setBookid(rs.getInt("bookid"));
				book.setAuthor(rs.getString("author"));
				book.setCategory(rs.getString("category"));
				book.setPrice(rs.getInt("price"));
				return book;
			});
		return bookList;

	}

	@Override
	public Book getBookById(int bookid) {
		String query = "select * from book where bookid=?";
		 Book newBook = jdbcTemplate.queryForObject(query, new Object[] {bookid},
			(rs, rowNum) -> {
				Book book  = new Book();
				String title = rs.getString("title");
				book.setTitle(title);
				book.setBookid(rs.getInt("bookid"));
				book.setAuthor(rs.getString("author"));
				book.setCategory(rs.getString("category"));
				book.setPrice(rs.getInt("price"));
				return book;
			});
		return newBook;
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
