package com.hotelapp.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue(generator = "add_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name = "add_seq",sequenceName = "add_seq")
	private Integer addressId;
	private String location;
	private String city;
	private long zipcode;
	public Address(String location, String city, long zipcode) {
		super();
		this.location = location;
		this.city = city;
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "Address [location=" + location + ", city=" + city + ", zipcode=" + zipcode + "]";
	}
	

}
