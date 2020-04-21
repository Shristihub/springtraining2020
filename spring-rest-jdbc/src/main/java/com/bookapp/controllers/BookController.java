package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.bean.Book;
import com.bookapp.service.BookService;

@RestController
@RequestMapping("book-api")
public class BookController {

	@Autowired
	BookService bookService;
	
	public void addBook(Book book) {
		
	}
	public List<Book> getAllBooks(){
		return null;
	}
	public List<Book>  getBookByCategory(String category){
		return null;
	}
	public Book getBookById(int bookid) {
		return null;
	}
	public void updateBook(Book book) {}
	
	@GetMapping("/book/{id}")
	void deleteBook(@PathVariable("id")int bookid) {
		bookService.deleteBook(bookid);
	}
}
