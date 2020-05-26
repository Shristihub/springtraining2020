package com.hotelapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelapp.models.Hotel;
import com.hotelapp.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository hotelRepository;
	@Override
	public void addHotel(Hotel hotel) {
		hotelRepository.save(hotel);
	}

	@Override
	public void updateHotel(Hotel hotel) {
		hotelRepository.save(hotel);
	}

	@Override
	public Hotel getHotelById(int hotelId) {
		return hotelRepository.findById(hotelId).get();
	}

	@Override
	public void deleteHotel(int hotelId) {
		hotelRepository.deleteById(hotelId);
	}

	@Override
	public List<Hotel> getHotelsByCity(String city) {
		return hotelRepository.findByAddressCity(city);
	}

	@Override
	public List<Hotel> getHotelsByMenu(String menuName) {
		return hotelRepository.getHotelsByMenu(menuName);
	}

	@Override
	public List<Hotel> getHotelsByDelivery(String partnerName) {
		return hotelRepository.getHotelsByDelivery(partnerName);
	}

	@Override
	public List<Hotel> getHotelsByLocation(String location) {
		return hotelRepository.findByAddressStreetName(location);
	}

	@Override
	public List<Hotel> getHotelsByLocationAndMenu(String location, String menuName) {
		return hotelRepository.getHotelsByLocationAndMenu(location, menuName);
	}

}
