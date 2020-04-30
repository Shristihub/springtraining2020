package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.bean.Book;
import com.bookapp.service.BookService;

@RestController
@RequestMapping("book-api")
public class BookController {

	@Autowired
	BookService bookService;
	@PostMapping(value = "/books", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public void addBook(Book book) {
		System.out.println(book);
		bookService.addBook(book);
		
	}
	
	@GetMapping("/book-by-id")
    public Book getBById(@RequestParam("bookid") int bookid){
        return bookService.getBookById(bookid);
    }     

	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	@GetMapping("/books-by-category/{category}")
	public List<Book>  getBookByCategory(@PathVariable("category")String category){
		
		return bookService.getBookByCategory(category);
	}
//	@GetMapping("/book-by-id/{bookid}")
//	public Book getBookById(@PathVariable("bookid")int bookid) {
//		return bookService.getBookById(bookid);
//	}
	public void updateBook(Book book) {}
	
	@GetMapping("/book/{id}")
	void deleteBook(@PathVariable("id")int bookid) {
		bookService.deleteBook(bookid);
	}
}
