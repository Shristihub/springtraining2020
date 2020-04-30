package com.bookapp.service;

import java.util.List;
import java.util.Optional;

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
		bookRepository.save(book);//cascade all ->author will be created and saved
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> bookList = bookRepository.findAll();
		return bookList;
	}

	@Override
	public List<Book> getBookByCategory(String category) {
		List<Book> bookList = bookRepository.findByCategory(category);
		/*if(bookList == null) {
			throw new BookNotFoundException();
		}*/
		return bookList;
	 }

	@Override
	public Book getBookById(int bookid) {
		Optional<Book> opt = bookRepository.findById(bookid);
		if(opt.isPresent()) {
		   return opt.get();	
		}
		return null;
	}

	@Override
	public void updateBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void deleteBook(int bookid) {
		bookRepository.deleteById(bookid);
	}

	@Override
	public List<Book> getByCategoryIgnoreCase(String category) {
		return bookRepository.findByCategoryContainingIgnoreCase(category);
	}

	@Override
	public List<Book> getByTitleAsc(String title) {
		return bookRepository.findByCategoryContainsOrderByTitleAsc(title);
	}

}
