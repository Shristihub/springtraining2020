package com.shristi.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Rectangle implements Shape {

	public void area(int x, int y) {
		System.out.println("rect" + (x * y));
	}

}
