package com.bookapp.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookService;
import com.bookapp.service.BookServiceImpl;

public class Client {

	public static void main(String[] args) {
		Book book1 = new Book("Node","Chris","Tech", 679.9, 3);
		BookService bookService = new BookServiceImpl();
		//bookService.addBook(book1);
		
		/*
		 * boolean result= true; try { result = bookService.deleteBook(2); } catch
		 * (BookNotFoundException e) { System.out.println(e.getMessage()); }
		 * System.out.println(result);
		 */
		
		/*List<Book> bookList = bookService.getAllBooks();
		bookList.stream()
		       .filter((book)->book.getPrice()>700)
		       .sorted((nbook1,nbook2)->{
		    	  return nbook2.getTitle().compareTo(nbook1.getTitle());   
		       }).forEach(System.out::println);
		*/
		try {
			List<Book> bookList = bookService.getBookbyAuthor("Raju");
			bookList.stream()
		       .filter((book)->book.getPrice()>700)
		       .sorted((nbook1,nbook2)->{
		    	  return nbook2.getTitle().compareTo(nbook1.getTitle());   
		       }).forEach(System.out::println);
		} catch (AuthorNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println("network error");
		}
		
		
		
	}

}
