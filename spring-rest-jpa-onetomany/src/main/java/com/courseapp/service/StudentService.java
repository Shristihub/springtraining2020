package com.courseapp.service;

import java.util.List;

import com.courseapp.bean.Student;

public interface StudentService {

	void addStudent(Student student);
	List<Student> getAllStudents();
	List<Student>  getStudByCity(String city);
	List<Student>  getStudByCourseName(String courseName);
	List<Student>  getByVehicleStudNameAsc(String type);
	Student getStudentById(int studentid);
	void updateStudent(Student student);
	void deleteStudent(int student);
}
