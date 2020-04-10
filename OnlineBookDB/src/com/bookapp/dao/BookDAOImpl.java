package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bookapp.bean.Book;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;

public class BookDAOImpl implements BookDAO {

	Connection connection;

	@Override
	public void addBook(Book book) {
		connection = DBConnection.openConnection();
		String sql = 
	"insert into Book(title,author,category,price,bookid) values(?,?,?,?,mysequence.nextval)";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getCategory());
			statement.setDouble(4, book.getPrice());
			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (statement != null)
					statement.close();
				DBConnection.closeConnection();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		}
	}

	@Override
	public boolean deleteBook(int bookid) throws BookNotFoundException {
		connection = DBConnection.openConnection();
		String sql = "delete from book where bookid = ?";
		PreparedStatement statement = null;
		boolean result = true;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, bookid);
			int val = statement.executeUpdate();
			if(val == 0) {
				result = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (statement != null)
					statement.close();
				DBConnection.closeConnection();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		}
		return result;
	}

	@Override
	public Book getBookById(int bookid) throws BookNotFoundException {
		connection = DBConnection.openConnection();
		String sql = "Select * from book where bookid = ?";
		PreparedStatement statement = null;
		Book book = new Book();
		try {
			statement =	
		connection.prepareStatement(sql, 
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
			statement.setInt(1,bookid);
			ResultSet rs = statement.executeQuery();
			if(!rs.next()) {
				throw new BookNotFoundException("ID not found");
			}
			rs.beforeFirst();
			while(rs.next()) {
				book.setAuthor(rs.getString("author"));
				book.setTitle(rs.getString("title"));
				book.setCategory(rs.getString("category"));
				book.setPrice(rs.getInt("price"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
			throw e;
		}
		finally {
			try {
				if (statement != null)
					statement.close();
				DBConnection.closeConnection();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		}
		return book;
	}

	@Override
	public boolean updateBook(int bookid, int price) {
		connection = DBConnection.openConnection();
		String sql = "update Book set price=? where bookid = ?";
		PreparedStatement statement = null;
		boolean result = true;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, price);
			statement.setInt(2, bookid);
			result = statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (statement != null)
					statement.close();
				DBConnection.closeConnection();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		}
		return result;
	}

	@Override
	public List<Book> getAllBooks() {
		connection = DBConnection.openConnection();
		String sql = "Select * from book";
		PreparedStatement statement = null;
		List<Book> bookList = new ArrayList<>();
		try {
			statement =	
		connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setAuthor(rs.getString("author"));
				book.setTitle(rs.getString("title"));
				book.setCategory(rs.getString("category"));
				book.setPrice(rs.getInt("price"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if (statement != null)
					statement.close();
				DBConnection.closeConnection();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		}
		return bookList;
	}

	@Override
	public List<Book> getBookbyAuthor(String author) throws AuthorNotFoundException {
		connection = DBConnection.openConnection();
		String sql = "Select * from book where author = ?";
		PreparedStatement statement = null;
		List<Book> bookList = new ArrayList<>();
		try {
			statement =	
		connection.prepareStatement(sql, 
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
			statement.setString(1,author);
			ResultSet rs = statement.executeQuery();
			if(!rs.next()) {
				throw new AuthorNotFoundException("Author not found");
			}
			rs.beforeFirst();
			while(rs.next()) {
				Book book = new Book();
				book.setAuthor(rs.getString("author"));
				book.setTitle(rs.getString("title"));
				book.setCategory(rs.getString("category"));
				book.setPrice(rs.getInt("price"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}catch (AuthorNotFoundException e) {
			System.out.println(e.getMessage());
			throw e;
		}finally {
			try {
				if (statement != null)
					statement.close();
				DBConnection.closeConnection();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		}
		return bookList;
	}

	@Override
	public List<Book> getBookbycategory(String category) 
			throws CategoryNotFoundException {
		connection = DBConnection.openConnection();
		String sql = "Select * from book where category like ?";
		PreparedStatement statement = null;
		List<Book> bookList = new ArrayList<>();
		try {
			statement =	
		connection.prepareStatement(sql, 
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
			statement.setString(1,"%"+category+"%");
			ResultSet rs = statement.executeQuery();
			if(!rs.next()) {
				throw new CategoryNotFoundException("Category not found");
			}
			rs.beforeFirst();
			while(rs.next()) {
				Book book = new Book();
				book.setAuthor(rs.getString("author"));
				book.setTitle(rs.getString("title"));
				book.setCategory(rs.getString("category"));
				book.setPrice(rs.getInt("price"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}catch (CategoryNotFoundException e) {
			System.out.println(e.getMessage());
			throw e;
		}finally {
			try {
				if (statement != null)
					statement.close();
				DBConnection.closeConnection();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		}
		return bookList;
	}

}
