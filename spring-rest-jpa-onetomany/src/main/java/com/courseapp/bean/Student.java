package com.courseapp.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue
	private int studentId;
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="stud_id")
	private Set<Vehicle> vehicleList;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="student_course",
		joinColumns = {@JoinColumn(name = "student_Id")},
		inverseJoinColumns = @JoinColumn(name = "course_Id"))
	private Set<Course> courseList;
	
	public Student(String name, Address address, Set<Vehicle> vehicleList, Set<Course> courseList) {
		super();
		this.name = name;
		this.address = address;
		this.vehicleList = vehicleList;
		this.courseList = courseList;
	}
	
	
	
}
