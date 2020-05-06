package com.hotelapp.service;

import java.util.List;

import com.hotelapp.bean.Hotel;

public interface HotelService {

	void addHotel(Hotel hotel);
	List<Hotel> getAllHotels();
	List<Hotel> getHotelsByMenu(String menuName);
	List<Hotel> getHotelsByDelivery(String delivery);
	List<Hotel> getHotelsByLocationAndMenus(String location,String menuName);
	List<Hotel> getHotelsByLocation(String location);
	Hotel getHotelById(int hotelId);
	
	

}
