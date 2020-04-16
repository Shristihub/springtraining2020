package com.shristi.autowiring;

import org.springframework.stereotype.Component;

public class Triangle implements Shape {

	public void area(int x, int y) {
		System.out.println("Tri" + (5* x * y));
	}

}
