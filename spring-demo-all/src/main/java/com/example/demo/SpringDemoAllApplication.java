package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.trainings.ShapeFactory;

@SpringBootApplication
@ComponentScan("com.example")
public class SpringDemoAllApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringDemoAllApplication.class);
		app.run();
	}

	@Autowired
	ShapeFactory factory;
	
	@Autowired
	ApplicationContext context;

	@Override
	public void run(String... args) throws Exception {

		factory.printArea("T",20,30);
		factory.printArea("R",20,30);
	
		String[] beanNames = context.getBeanDefinitionNames();
		for (String bean : beanNames) {
			System.out.println(bean);
		}
	}
	
	
}
