package com.bookapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.bean.Author;

@Repository
public interface AuthorRepository  extends JpaRepository<Author,Integer>{
	

}
