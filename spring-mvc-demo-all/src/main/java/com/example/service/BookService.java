package com.example.service;

import java.util.List;

import com.example.bean.Book;

public interface BookService {

	public Book getBookbyId(int bookid);
	public List<Book> getBookByAuthor(String author);
}
