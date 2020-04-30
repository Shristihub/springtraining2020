package com.bookapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.bean.Author;
import com.bookapp.bean.Book;
import com.bookapp.service.BookService;

@SpringBootApplication
public class SpringRestJpaH2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestJpaH2Application.class, args);
	}

	@Autowired
	BookService bookService;

	@Override
	public void run(String... args) throws Exception {
		List<Author> authorList = Arrays.asList(new Author("Jack","Thomas"),new Author("Jill","Grake"));
		Book book = new Book("The seven", authorList, "Thriller", 3000);
		bookService.addBook(book);

		book = new Book("The rat race", 
				Arrays.asList(new Author("Geranimo","Stilton"),new Author("Nipun","Harsha")), "Kids", 900);
		bookService.addBook(book);

//		authorList = Arrays.asList(author1, author4);
//		book = new Book("Miracle morning", authorList, "Self", 900);
//		bookService.addBook(book);
//
//		authorList = Arrays.asList(author3, author4);
//		book = new Book("Ferrari", authorList, "self", 900);
//		bookService.addBook(book);
//
//		authorList = Arrays.asList(author2, author4);
//		book = new Book("Ninja warrior", authorList, "Fiction", 900);
//		bookService.addBook(book);
//
//		authorList = Arrays.asList(author2, author4);
//		book = new Book("Angular Js", authorList, "Tech", 900);
//		bookService.addBook(book);
//
		bookService.getAllBooks().forEach(System.out::println);
		System.out.println();
//		bookService.getByCategoryIgnoreCase("self").forEach(System.out::println);
//		System.out.println();
//		bookService.getByTitleAsc("tech").forEach(System.out::println);
//		System.out.println();

	}

}
