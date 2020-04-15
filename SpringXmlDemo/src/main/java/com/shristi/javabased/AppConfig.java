package com.shristi.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

	@Bean
	public Employee getEmp() {
		return new Employee();
	}

	@Bean
	public Address getAddress() {
		return new Address();
	}

}
