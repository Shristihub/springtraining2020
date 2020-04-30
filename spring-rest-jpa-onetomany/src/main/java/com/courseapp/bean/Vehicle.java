package com.courseapp.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vehicle {

	@Id
	@GeneratedValue
	private Integer vehicleId;
	private String type;
	private String vehicleNumber;
	public Vehicle(String type, String vehicleNumber) {
		super();
		this.type = type;
		this.vehicleNumber = vehicleNumber;
	}
	@Override
	public String toString() {
		return "Vehicle [type=" + type + ", vehicleNumber=" + vehicleNumber + "]";
	}
	
	
}
