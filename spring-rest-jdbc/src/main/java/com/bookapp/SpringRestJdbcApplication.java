package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.bean.Book;
import com.bookapp.service.BookService;

@SpringBootApplication
public class SpringRestJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestJdbcApplication.class, args);
	}

	@Autowired
	BookService bookService;
	
	@Override
	public void run(String... args) throws Exception {
//		Book book = new Book("Happiness","Zeena","Fiction",900,22);
//		bookService.addBook(book);
//		book = new Book("Famous Five","Enid","Fiction",900,23);
//		bookService.addBook(book);
//		book = new Book("Spring","Rod","Tech",900,24);
//		bookService.addBook(book);
		
		System.out.println();
		bookService.getAllBooks().forEach(System.out::println);
		System.out.println();
		bookService.getBookByCategory("Fiction").forEach(System.out::println);
		System.out.println();
		Book newBook = bookService.getBookById(24);
		System.out.println(newBook);
//		book.setPrice(1200);
//		bookService.updateBook(book);
//		bookService.deleteBook(1);
	}

}
