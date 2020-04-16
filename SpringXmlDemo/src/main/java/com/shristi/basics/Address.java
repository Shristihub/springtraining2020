package com.shristi.basics;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope("prototype")
public class Address { 
	String city;
	long zipcode;
	public String getCity() {
		return city;
	}
	@Value("${employ.address.city}")
	public void setCity(String city) {
		this.city = city;
	}
	public long getZipcode() {
		return zipcode;
	}
	@Value("${employ.address.zip}")
	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", zipcode=" + zipcode + "]";
	}
	
		
}
