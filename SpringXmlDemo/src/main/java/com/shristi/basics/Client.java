package com.shristi.basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {

		ApplicationContext context = 
				new AnnotationConfigApplicationContext("com.shristi") ;
				//new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Employee employee = context.getBean(Employee.class);
		System.out.println("Employee-1: "+employee);
//		System.out.println("Employee-1: "+employee.getAddress().getCity());
//		Address address = context.getBean(Address.class);
//		address.setCity("Pune");
//		employee.setAddress(address);
//		System.out.println("Employee-1: "+employee.getAddress().getCity());
//		
//		Employee employee1 = context.getBean(Employee.class);
//		System.out.println("Employee-2: "+employee1.getName());
//		System.out.println("Employee-2: "+employee1.getAddress().getCity());
	}

}





