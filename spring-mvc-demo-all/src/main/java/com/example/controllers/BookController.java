package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bean.Book;
import com.example.service.BookService;

@Controller
public class BookController {

	@RequestMapping("/")
	public String home() {
		return "home";
		
	}
	
//	@RequestMapping("/myMsg")
//	public String showMesage(Model model) {
//		// call service
//		model.addAttribute("message", "Welcome to Spring");
//		return "hello";
//		
//	}
//	@RequestMapping("/welcomeMsg")
//	public String sayHello(ModelMap model) {
//		// call service
//		model.addAttribute("message", "I am from model map");
//		return "hello";
//		
//	}
//	@RequestMapping("/greetMsg")
//	public ModelAndView greetMessage() {
//		// call service
//		ModelAndView model = new ModelAndView("hello", "message","This is model amd view");
//		return model;
//		
//	}
	@Autowired
	BookService bookService;
	
	
	@RequestMapping("/book-by-id/{bookid}")
	public String getBookById(@PathVariable("bookid")int id, Model model) {
		Book book = bookService.getBookbyId(id);
		model.addAttribute("book",book);
		return "hello";
	}
	@RequestMapping("/book-by-author/{author}")
	public String getBookByAuthor(@PathVariable("author")String author, Model model) {
		List<Book> booksByAuthor = bookService.getBookByAuthor(author);
		model.addAttribute("bookList",booksByAuthor);
		return "hello";
	}
	
	@RequestMapping("/one-book")
	public String getOne(@RequestParam("bookid")int id, Model model) {
		Book book = bookService.getBookbyId(id);
		model.addAttribute("book",book);
		return "hello";
	}
	@RequestMapping("/books-by-author")
	public String getByAuthor(@RequestParam("author")String author, Model model) {
		List<Book> booksByAuthor = bookService.getBookByAuthor(author);
		model.addAttribute("bookList",booksByAuthor);
		return "hello";
	}
	
}
