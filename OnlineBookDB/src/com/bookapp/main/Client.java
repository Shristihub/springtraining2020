package com.bookapp.main;

import java.util.List;

import com.bookapp.bean.Book;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.service.BookService;
import com.bookapp.service.BookServiceImpl;

public class Client {

	public static void main(String[] args) {
	
		BookService service = new BookServiceImpl();
//		Scanner sc = new Scanner(System.in);
//		for (int i = 0; i < 4; i++) {
//			Book book = new Book();
//			System.out.println("enter title");
//			String title = sc.next();
//			System.out.println("enter price");
//			int price = sc.nextInt();
//			System.out.println("enter author");
//			String author = sc.next();
//			book.setTitle(title);
//			book.setPrice(price);
//			book.setAuthor(author);
//			System.out.println("enter category");
//			book.setCategory(sc.next());
//			service.addBook(book);
//			sc.nextLine();
//		}
//		
		service.addBook(new Book("Javadd","Kathy","Tech",900));
		service.addBook(new Book("Wonder","Dave","Fiction",1900));
		service.addBook(new Book("Spring","Johnson","Tech",2300));
		service.addBook(new Book("Goosebumps","Harry","Fiction",800));
		service.addBook(new Book("Inspire","Raja","SelfHelp",290));
		
		System.out.println(service.getAllBooks());
		 
		try {
			List<Book> bookList = service.getBookbyAuthor("A");
			for (Book book : bookList) {
				System.out.println(book);
			}
		} catch (AuthorNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
