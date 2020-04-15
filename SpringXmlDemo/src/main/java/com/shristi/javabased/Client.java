package com.shristi.javabased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {

		ApplicationContext context = 
				new AnnotationConfigApplicationContext("com.shristi.javabased") ;
				//new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Employee employee = context.getBean("getEmp",Employee.class);
		System.out.println("Employee-1: "+employee);
		String[] beans = context.getBeanDefinitionNames();
		for (String beanName : beans) {
			System.out.println(beanName);
		}
	}

}





