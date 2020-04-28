package com.bookapp.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {

	String title,author,category;
	int price;
	@Id
	Integer bookid;
	public Book(String title, String author, String category, int price, int bookid) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		this.bookid = bookid;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", category=" + category + ", price=" + price
				+ ", bookid=" + bookid + "]";
	}
	
}
