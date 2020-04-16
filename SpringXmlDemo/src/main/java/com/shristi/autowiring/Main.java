package com.shristi.autowiring;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext("com.shristi.autowiring") ;
			ShapeFactory factory = context.getBean(ShapeFactory.class);
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter r or t");
			String choice = sc.next();
			factory.printArea(choice.toUpperCase(),20, 30);
		String[] beans = context.getBeanDefinitionNames();
		for (String beanName : beans) {
			System.out.println(beanName);
		}
		
	}

}
