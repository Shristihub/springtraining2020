package com.example.bean;

public class Book {
	String title;
	String author;
	int bookid;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(String title, String author, int bookid) {
		super();
		this.title = title;
		this.author = author;
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", bookid=" + bookid + "]";
	}
	

}
