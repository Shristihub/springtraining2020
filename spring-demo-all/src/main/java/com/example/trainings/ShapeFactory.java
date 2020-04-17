package com.example.trainings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeFactory {
	@Autowired
	@Qualifier("rectangle")
	Shape shape;
	
	@Autowired
	@Qualifier("triangle")
	Shape nshape ;
	
	
	public void printArea(String choice,int x, int y) {
		System.out.println("In ShapeFactory class");
		if(choice.equals("R"))
			shape.area(x, y);
		else if(choice.equals("T"))
			
			nshape.area(x, y);
		else
			System.out.println("Wrong input");
	}
	
}
