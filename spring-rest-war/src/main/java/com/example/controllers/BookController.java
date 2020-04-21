package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Book;
import com.example.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/greet")
	public String greet() {
		return "welcome to spring!!!!";
	}
	
	@GetMapping("/book/{bookId}")
	public Book findById(@PathVariable("bookId")int id) {
	 Book book = bookService.getBookbyId(id);	
		return book;
	}
	@GetMapping("/books-by-author/{author}")
	public List<Book> findById(@PathVariable("author")String author) {
	 return bookService.getBookByAuthor(author);	
	}
	
}
