package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;
import com.bookapp.model.Book;

public class BookDAOImpl implements BookDAO {
	Connection connection;

	public void addBook(Book book) {
		connection = DbUtil.openConnection();
		String sql = "insert into book values(?,?,?,?,?)";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, book.getTitle());
			statement.setInt(2, book.getBookId());
			statement.setString(3, book.getAuthor());
			statement.setString(4, book.getCategory());
			statement.setDouble(5, book.getPrice());
			statement.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			DbUtil.closeConnection();
		}
	}

	public boolean deleteBook(int id) throws BookNotFoundException{
		connection = DbUtil.openConnection();
		String sql = "delete from book where book_id = ?";
		PreparedStatement statement = null;
		boolean isdeleted = true;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			isdeleted = statement.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			DbUtil.closeConnection();
		}
		return isdeleted;
	}

	public Book getBookById(int bookid) throws BookNotFoundException {
		return null;
	}

	public boolean updateBook(int bookid, int price) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Book> getAllBooks() {
		connection = DbUtil.openConnection();
		String sql = "select * from book";
		PreparedStatement statement = null;
		List<Book> bookList = null;
		try {
			statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			bookList = new ArrayList<>();
			
			while(rs.next()) {
				String title = rs.getString("title");
				String category = rs.getString("category");
				int bookid = rs.getInt("bookid");
				double price = rs.getDouble("price");
				
				Book book = new Book();	
				book.setAuthor(rs.getString("author"));
				book.setBookId(bookid);
				book.setCategory(category);
				book.setPrice(price);
				book.setTitle(title);
				bookList.add(book);
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			DbUtil.closeConnection();
		}
		
		return bookList;
	}

	public List<Book> getBookbyAuthor(String author) throws AuthorNotFoundException {
		connection = DbUtil.openConnection();
		String sql = "select * from book where author = ?";
		PreparedStatement statement = null;
		List<Book> bookList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			statement.setString(1,author);
			ResultSet rs = statement.executeQuery();
			if(!rs.next()) {
				throw new AuthorNotFoundException("Author not available");
			}
			rs.beforeFirst();
			while(rs.next()) {
				Book book = new Book();	
				book.setAuthor(rs.getString("author"));
				book.setBookId(rs.getInt("bookid"));
				book.setCategory(rs.getString("category"));
				book.setPrice(rs.getDouble("price"));
				book.setTitle(rs.getString("title"));
				bookList.add(book);
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			DbUtil.closeConnection();
		}
		
		return bookList;
	}

	public List<Book> getBookbycategory(String category) throws CategoryNotFoundException {
		return null;
	}

}
