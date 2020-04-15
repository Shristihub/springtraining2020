package com.shristi.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@PropertySource("classpath:application.properties")
public class Employee {

	String name;
	int empId;
	@Autowired
	Department department;
	Address address;
	
	@Autowired
	public Employee(Address address) {
		this.address=address;
	}
	public String getName() {
		return name;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Value("${employ.name}")
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpId() {
		return empId;
	}
	@Value("${employ.empId}")
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", empId=" + empId + ", department=" + department + ", address=" + address
				+ "]";
	}
	
	
	
	
	
}
