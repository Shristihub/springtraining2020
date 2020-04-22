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
		System.out.println("......"+bookList);
		List<Book> newBookList = new ArrayList<Book>();
		for(Book book:bookList) {
			if(book.getPrice()<1000)
				newBookList.add(book);
		}
		Collections.sort(newBookList,new Comparator<Book>() {

			@Override
			public int compare(Book book1, Book book2) {
				return book1.getAuthor().compareTo(book2.getAuthor());
			}
		
		});
		return newBookList;
		/*if(bookList == null) {
			throw new BookNotFoundException();
		}
		return bookList
				.stream()
				.filter(book->book.getPrice()>1000)
				.sorted((book1,book2)->	book1.getAuthor().compareTo(book2.getAuthor()))
				.collect(Collectors.toList());*/
	}

	@Override
	public List<Book> getBookByCategory(String category) {
		List<Book> bookList = bookDAO.getBookByCategory(category);
		/*if(bookList == null) {
			throw new BookNotFoundException();
		}*/
		return bookList
				.stream()
				.sorted((book1,book2)->	book1.getAuthor().compareTo(book2.getAuthor()))
				.filter((book)->book.getPrice()>1000)
				.limit(2)
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
