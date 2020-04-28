package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.bean.Book;
import com.bookapp.dao.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;
	@Override
	public void addBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public List<Book> getBookByCategory(String category) {
		//return bookRepository.findByCategoryOrderByTitleAsc(category);
		return bookRepository.findByCategoryAndPrice(category, 900);
	}

	@Override
	public Book getBookById(int bookid) {
		// TODO Auto-generated method stub
		return bookRepository.getOne(bookid);
	}

	@Override
	public void updateBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void deleteBook(int bookid) {
		bookRepository.deleteById(bookid);
	}

}
