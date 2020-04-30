package com.bookapp.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Book {

	String title,category;
	int price;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer bookid;
	@ManyToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinTable(
			name="book_author", 
			joinColumns={@JoinColumn(name="bookid")},
			inverseJoinColumns=@JoinColumn(name="authorid"))
	List<Author> authorList;
	public Book(String title, List<Author> authorList, String category, int price) {
		super();
		this.title = title;
		this.authorList = authorList;
		this.authorList.forEach(author->author.getBookList().add(this));
		this.category = category;
		this.price = price;
	}
	
}
