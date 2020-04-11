package com.shristi.basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {

		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//Employee employee = (Employee)context.getBean("employee");
		Employee employee1 = context.getBean("employee",Employee.class);
		System.out.println(employee1);
		
	}

}
