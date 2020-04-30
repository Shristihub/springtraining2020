package com.bookapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.bean.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
 
    // derived queries
	List<Book> findByCategory(String category);
	List<Book> findByCategoryContainingIgnoreCase(String title);
	List<Book> findByCategoryContainsOrderByTitleAsc(String title);

}
