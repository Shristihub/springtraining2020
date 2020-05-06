package com.hotelapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelapp.bean.Hotel;
import com.hotelapp.dao.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository hotelRepository;

	@Override
	public void addHotel(Hotel hotel) {
		hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public List<Hotel> getHotelsByMenu(String menuName) {
		return hotelRepository.findByMenus(menuName);
	}

	@Override
	public List<Hotel> getHotelsByDelivery(String delivery) {
		return hotelRepository.findByDelivery(delivery);
	}

	@Override
	public List<Hotel> getHotelsByLocationAndMenus(String location,String menuName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel getHotelById(int hotelId) {
		return hotelRepository.findById(hotelId).get();
	}

	@Override
	public List<Hotel> getHotelsByLocation(String location) {
		return hotelRepository.findByAddressLocation(location);
	}

}
