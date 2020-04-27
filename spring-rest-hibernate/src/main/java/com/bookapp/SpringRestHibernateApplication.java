package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.bookapp.bean.Book;
import com.bookapp.service.BookService;

@SpringBootApplication
@ComponentScan("com")
public class SpringRestHibernateApplication implements CommandLineRunner{
	@Autowired
	BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(SpringRestHibernateApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Book book = new Book("Spring","Rod","Self",1900,103);
		//bookService.addBook(book);
//		book = new Book("Famous Five","Enid","Fiction",900,23);
//		bookService.addBook(book);
//		book = new Book("Spring","Rod","Tech",900,24);
//		bookService.addBook(book);
		
//		System.out.println();
		bookService.getAllBooks().forEach(System.out::println);
		System.out.println();
		bookService.getBookByCategory("Fiction").forEach(System.out::println);
		System.out.println();
		Book newBook = bookService.getBookById(101);
		System.out.println(newBook);
		book.setPrice(1200);
		bookService.updateBook(book);
		bookService.deleteBook(2);
//		
//		newBook = bookService.getBookById(1);
//		System.out.println(newBook);
		
		
	}	

}
