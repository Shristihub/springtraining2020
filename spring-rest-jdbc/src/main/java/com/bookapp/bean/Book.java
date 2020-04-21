package com.bookapp.bean;

public class Book {

	String title,author,category;
	int price;
	int bookid;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String title, String author, String category, int price, int bookid) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", category=" + category + ", price=" + price
				+ ", bookid=" + bookid + "]";
	}
	
}
