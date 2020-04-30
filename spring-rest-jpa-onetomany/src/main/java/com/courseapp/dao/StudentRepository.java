package com.courseapp.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.courseapp.bean.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	// derived query
	List<Student> findByAddressCity(String city);
	
	//List<Student> findByVehicleType(String type, Sort sort);
	
	@Query("From Vehicle v inner join Course c where c.courseName=?1")
	List<Student> findbyCourseName(String courseName);
   
}
