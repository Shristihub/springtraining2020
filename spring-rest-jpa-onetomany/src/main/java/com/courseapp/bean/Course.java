package com.courseapp.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course {

	@Id
	@GeneratedValue
	private Integer courseId;
	private String courseName;
	@ManyToMany(mappedBy = "courseList")
	Set<Student> studentList = new HashSet<>() ;
	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return "Course [courseName=" + courseName + "]";
	} 
	
	
}
