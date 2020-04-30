package com.bookapp.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Author {

	String firstName,lastName;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer authorid;
	@ManyToMany(mappedBy="authorList",fetch=FetchType.EAGER)
	List<Book> bookList = new ArrayList<>();

	public Author(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "Author [firstName=" + firstName + "]";
	}
	
}

