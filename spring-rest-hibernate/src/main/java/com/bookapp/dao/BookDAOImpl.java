package com.bookapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bookapp.bean.Book;

@Repository
public class BookDAOImpl implements BookDAO {
	@Autowired
	SessionFactory factory;

	@Override
	public void addBook(Book book) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(book);
		transaction.commit();
		session.close();
	}

	@Override
	public List<Book> getAllBooks() {
		Session session = factory.openSession();
		// write query with regard to the entity
		// will pass query to the db
//		Query<Book> query = session.createQuery("from MyBook");
		Query<Book> query = session.createQuery("from Book");
		// get resultset create domain object
		//set values from row
		//add it to a list
		List<Book> bookList = query.list();
		return bookList;
	}

	@Override
	public List<Book> getBookByCategory(String category) {
		Session session = factory.openSession();
		// write query with regard to the entity
//		String bookquery = "from MyBook b where b.category like :choice";
		String bookquery = "from Book b where b.category like :choice";
		// will pass query to the db
//		Query<Book> query = session.createQuery(bookquery);
//		query.setParameter("choice", category);
//		List<Book> bookList = query.list();
	
		List<Book> bookList = 
			session.createQuery(bookquery).setParameter("choice",category).list();
		
		return bookList;
	}

	@Override
	public Book getBookById(int bookid) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Book book = session.get(Book.class,bookid);
		transaction.commit();
		return book;
	}

	@Override
	public void updateBook(Book book) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(book);
		transaction.commit();
		session.close();
		
	}

	@Override
	public void deleteBook(int bookid) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Book book = session.get(Book.class,bookid);
//		session.delete("MyBook",book);
		session.delete(book);
		transaction.commit();
		session.close();		
	}

	
}
