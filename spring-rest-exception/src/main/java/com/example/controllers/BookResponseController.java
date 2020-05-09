package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Book;
import com.example.exception.AuthorNotFoundException;
import com.example.exception.IdNotFoundException;
import com.example.service.BookService;

@RestController
@RequestMapping("book-api-response")
public class BookResponseController {

	@Autowired
	BookService bookService;
	
	@PostMapping("/books")
	public ResponseEntity<List<Book>> getAll(){
		List<Book> bookList = bookService.getAll();
		return new ResponseEntity<>(bookList,HttpStatus.OK);
	}
	@GetMapping("/books/books-by-author")
	public ResponseEntity<List<Book>> getBooksByAuthor(@RequestParam(required=true)String author){
		List<Book> bookList = bookService.getBookByAuthor(author);
		return new ResponseEntity<>(bookList,HttpStatus.OK);
	}
	@GetMapping("/books/book-by-id/{bookId}")
	public ResponseEntity<Book> getById(@PathVariable("bookId")int bookId){
		Book book = bookService.getBookbyId(bookId);
//		return new ResponseEntity<>(book,HttpStatus.OK);
		return ResponseEntity.ok().body(book);
	}
	
	
	
	
}







