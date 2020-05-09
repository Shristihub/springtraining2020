package com.example.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.bean.Book;
import com.example.exception.AuthorNotFoundException;
import com.example.exception.IdNotFoundException;

@Service
public class BookServiceImpl implements BookService {

	
	@Override
	public Book getBookbyId(int bookid) throws IdNotFoundException {
			return getAllBooks()
				.stream()
				.filter((book)->book.getBookid()==bookid)
				.findAny()
				.orElseThrow(()-> new IdNotFoundException("Book with Id "+bookid+" not found"));
	}

	@Override
	public List<Book> getBookByAuthor(String author) throws AuthorNotFoundException {
		List<Book> bookList = getAllBooks()
				.stream()
				.filter((book)->book.getAuthor().equals(author))
				.collect(Collectors.toList());
		if(bookList.isEmpty()) {
			throw new AuthorNotFoundException("Author not available");
		}
		return bookList;
	}

	private List<Book> getAllBooks(){
		return Arrays.asList(new Book("Java","Kathy",10),
				new Book("Death Note","Kumaran",11),
				new Book("Spring","Rod",12),
				new Book("JEE","Kathy",13),
				new Book("Mummy","Kumaran",14));
	}

	@Override
	public List<Book> getAll() {
		return getAllBooks();
	}

}
