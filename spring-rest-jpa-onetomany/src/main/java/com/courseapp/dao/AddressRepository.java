package com.courseapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.courseapp.bean.Student;

@Repository
public interface AddressRepository extends JpaRepository<Student, Integer>{
	
   
}
