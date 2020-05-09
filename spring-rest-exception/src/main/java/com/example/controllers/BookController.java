package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Book;
import com.example.exception.AuthorNotFoundException;
import com.example.exception.IdNotFoundException;
import com.example.service.BookService;

@RestController
@RequestMapping("book-api")
public class BookController {

	@Autowired
	BookService bookService;
	
	
	@GetMapping("/book/{bookId}")
	public Book findById(@PathVariable("bookId")int id) throws IdNotFoundException{
	 Book book = bookService.getBookbyId(id);	
	 if(book==null) {
		 throw new IdNotFoundException("Book with this id not available");
	 }
		return book;
	}
	@GetMapping("/books-by-author")
	public List<Book>  findById(@RequestParam(required = true)String author) throws AuthorNotFoundException {
		List<Book> bookList = bookService.getBookByAuthor(author);
		if(bookList.isEmpty())
			throw new AuthorNotFoundException("Author not avaiable");
		return bookList;
	}
	//@ExceptionHandler(IdNotFoundException.class)
	public String handleIDException(Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
		return e.getMessage();
//		return "home";          // mvc based application
	}
	//@ExceptionHandler(AuthorNotFoundException.class)
	public String handleAuthorException(Exception e) {
		System.out.println(e.getMessage());
		return e.getMessage();
	}
	
}







