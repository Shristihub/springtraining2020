package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.service.BookService;

@SpringBootApplication
public class SpringDemoRestApplication implements CommandLineRunner{

	@Autowired
	BookService bookService;
	public static void main(String[] args) {
		SpringApplication.run(SpringDemoRestApplication.class, args);
		System.out.println("hello");
	}
	
	
	@Override
	public void run(String... args) throws Exception {

		System.out.println("Book by id "+bookService.getBookbyId(12));
		bookService.getBookByAuthor("Kumaran")
		        .forEach(System.out::println);
	}

}
