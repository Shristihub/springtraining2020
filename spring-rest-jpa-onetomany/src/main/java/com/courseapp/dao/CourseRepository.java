package com.courseapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.courseapp.bean.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	
   
}
