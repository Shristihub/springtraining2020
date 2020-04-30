package com.courseapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.courseapp.bean.Student;
import com.courseapp.dao.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	@Override
	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public List<Student> getStudByCity(String city) {
		return studentRepository.findByAddressCity(city);
	}

	@Override
	public List<Student> getStudByCourseName(String courseName) {
		return studentRepository.findbyCourseName(courseName);
	}

	@Override
	public List<Student> getByVehicleStudNameAsc(String type) {
		Sort sort = Sort.by("name").ascending();
	//	return studentRepository.findByVehicleType(type,sort);
		return null;
	}

	@Override
	public Student getStudentById(int studentid) {
		// TODO Auto-generated method stub
		return studentRepository.findById(studentid).get();
	}

	@Override
	public void updateStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void deleteStudent(int studentid) {
		studentRepository.deleteById(studentid);
	}

}
