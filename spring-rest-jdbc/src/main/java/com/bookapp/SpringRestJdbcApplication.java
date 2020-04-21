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
		Book book = new Book("Happiness","Ravi","Fiction",900,21);
//		bookService.addBook(book);
//		book.setPrice(1200);
//		bookService.updateBook(book);
//		bookService.deleteBook(1);
	}

}
