package com.example.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.bean.Book;

@Service
public class BookServiceImpl implements BookService {

	@Override
	public Book getBookbyId(int bookid) {
		return getAllBooks()
				.stream()
				.filter((book)->book.getBookid()==bookid)
				.findAny()
				.get();
	}

	@Override
	public List<Book> getBookByAuthor(String author) {
		return getAllBooks()
				.stream()
				.filter((book)->book.getAuthor().equals(author))
				.collect(Collectors.toList());
	}

	private List<Book> getAllBooks(){
		return Arrays.asList(new Book("Java","Kathy",10),
				new Book("Death Note","Kumaran",11),
				new Book("Spring","Rod",12),
				new Book("JEE","Kathy",13),
				new Book("Mummy","Kumaran",14));
	}
}
