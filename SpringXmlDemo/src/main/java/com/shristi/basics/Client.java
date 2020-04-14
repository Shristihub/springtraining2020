package com.shristi.basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {

		ApplicationContext context = 
				new AnnotationConfigApplicationContext("com.shristi") ;
		Employee employee = context.getBean(Employee.class);
		System.out.println(employee);
		
	}

}





