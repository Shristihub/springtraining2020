package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.bean.Book;
import com.bookapp.service.BookService;

@SpringBootApplication
public class SpringRestJpaMysqlApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestJpaMysqlApplication.class, args);
	}

	@Autowired
	BookService bookService;

	@Override
	public void run(String... args) throws Exception {

		Book book = new Book("The Hunt", "Geronimo", "Fiction", 900,1);
		bookService.addBook(book);
		book = new Book("Birthday Party", "Enid", "Comic", 200, 2);
		bookService.addBook(book);

//		System.out.println();
//		bookService.getAllBooks().forEach(System.out::println);
//		System.out.println();
//
//		bookService.getBookByCategory("Fiction").forEach(System.out::println);
		System.out.println(".......By Id......");
		Book newBook = bookService.getBookById(1);
		System.out.println(newBook);
		book.setPrice(1200);
		bookService.updateBook(book);
////		bookService.deleteBook();
	}

}
