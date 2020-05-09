package com.example.service;

import java.util.List;

import com.example.bean.Book;
import com.example.exception.AuthorNotFoundException;
import com.example.exception.IdNotFoundException;

public interface BookService {

	public Book getBookbyId(int bookid) throws IdNotFoundException;
	public List<Book> getAll();
	public List<Book> getBookByAuthor(String author) throws AuthorNotFoundException;
}




