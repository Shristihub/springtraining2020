package com.bookapp.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity(name = "MyBook")
@Entity
//@Table(name = "Book")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Book {

	String title,author,category;
	double price;
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	int bookid;
	public Book(String title, String author, String category, double price, int bookid) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		this.bookid = bookid;
	}
	
}
