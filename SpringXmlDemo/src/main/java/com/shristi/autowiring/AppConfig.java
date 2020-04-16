package com.shristi.autowiring;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

	@Bean
	public ShapeFactory shapeFactory() {
		return new ShapeFactory();
	}
	@Bean
	@Primary
	public Rectangle rectangle() {
		return new Rectangle();
	}
	@Bean
	public Triangle triangle() {
		return new Triangle();
	}
	
	
}
