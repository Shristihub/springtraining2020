package com.courseapp;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.courseapp.bean.Address;
import com.courseapp.bean.Course;
import com.courseapp.bean.Student;
import com.courseapp.bean.Vehicle;
import com.courseapp.service.StudentService;

@SpringBootApplication
public class SpringRestJpaOnetomanyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestJpaOnetomanyApplication.class, args);
	}

	@Autowired
	StudentService studentService;
	@Override
	public void run(String... args) throws Exception {
		
		Address address = new Address("ABC Nagar","Bangalore",78657980);
		Course course1 = new Course("Java");
		Course course2 = new Course("Spring");
		Course course3= new Course("Angular");
		Set<Course> courseList = new HashSet<>();
		courseList.add(course1);
		courseList.add(course2);
		courseList.add(course3);
		
		Vehicle vehicle1 = new Vehicle("Car","KA01 2340");
		Vehicle vehicle2 = new Vehicle("Bike","KA01 2341");
		Set<Vehicle> vehicleList = new HashSet<>();
		vehicleList.add(vehicle1);
		vehicleList.add(vehicle2);
				
		Student student = new Student("Raju",address,vehicleList,courseList);
		studentService.addStudent(student);
		
		
	}

}
