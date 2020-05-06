package com.hotelapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hotelapp.bean.Address;
import com.hotelapp.bean.Delivery;
import com.hotelapp.bean.Hotel;
import com.hotelapp.bean.Menu;
import com.hotelapp.service.HotelService;

@SpringBootApplication
public class SpringHotelappRestApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringHotelappRestApplication.class, args);
	}

	@Autowired
	HotelService hotelService;
	
	@Override
	public void run(String... args) throws Exception {
		
	 Address address =new Address("xyz nagar","Bangalore",560987);	
	 
	 Menu menu = new Menu();
	 menu.setMenuName("Paratha");
	 menu.setCost(20.0);
	 Menu menu1 = new Menu();
	 menu1.setMenuName("Poha");
	 menu1.setCost(30.0);	 
	 Set<Menu> menuList = new HashSet<>(Arrays.asList(menu, menu1));
	 
	 Delivery delivery = new Delivery();
	 delivery.setDeliveryName("Swiggy");
	 delivery.setCharges(120.0);
	 Set<Delivery> deliveryList = new HashSet<>(Arrays.asList(delivery));
	 
	 Hotel hotel = new Hotel();
	 hotel.setHotelName("The Dhabba");
	 hotel.setAddress(address);
	 hotel.setMenuList(menuList);
	 hotel.setDelivery(deliveryList);
	 
	// hotelService.addHotel(hotel);
	 List<Hotel> hotelList = hotelService.getHotelsByLocation("xyz nagar");
	 for (Hotel hotel2 : hotelList) {
		System.out.println("Name "+hotel2.getHotelName());
		System.out.println("Location "+hotel2.getAddress().getLocation());
		System.out.println("City "+hotel2.getAddress().getCity());
		System.out.println("Menus "+hotel2.getMenuList());
		System.out.println("Delivery "+hotel2.getDelivery());
	}
	}



}
