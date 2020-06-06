package com.hotelapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelapp.models.Hotel;
import com.hotelapp.service.HotelService;

@RestController
@RequestMapping("hotel-restapi")
public class HotelController {

	@Autowired
	HotelService hotelService;
	
	@PostMapping("/hotels")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
		Hotel newHotel = hotelService.addHotel(hotel);
		return ResponseEntity.ok(newHotel);
		
	}
	@PatchMapping("/hotels-update")
	public ResponseEntity<String> updateHotel(Hotel hotel) {
		hotelService.updateHotel(hotel);
		return new ResponseEntity<String>("updated",HttpStatus.OK);
	}
	@GetMapping("/hotel-by-id/{hotelId}")
	public Hotel getHotelById(@PathVariable int hotelId) {
		return hotelService.getHotelById(hotelId);
	}
	@GetMapping("/hotel-delete/{hotelId}")
	public ResponseEntity<String> deleteHotel(int hotelId) {
		hotelService.deleteHotel(hotelId);
		return ResponseEntity.ok("deleted");
	}
	@GetMapping("/hotels-by-city/{city}")
	List<Hotel> getHotelsByCity(@PathVariable String city){
		return hotelService.getHotelsByCity(city);
	}
	@GetMapping("/hotels-by-menu/{menuName}")
	List<Hotel> getHotelsByMenu(@PathVariable String menuName){
		return hotelService.getHotelsByMenu(menuName);
	}
	@GetMapping("/hotels-by-delivery/{partnerName}")
	List<Hotel> getHotelsByDelivery(@PathVariable String partnerName){
		return hotelService.getHotelsByDelivery(partnerName);
	}
	@GetMapping("/hotels-by-location/")
	List<Hotel> getHotelsByLocation(@RequestParam("location") String location){
		return hotelService.getHotelsByLocation(location);
	} 
	@GetMapping("/hotels-by-location/{location}/menu/{menuName}")
	List<Hotel> getHotelsByLocationAndMenu(@PathVariable String location,@PathVariable String menuName){
		return hotelService.getHotelsByLocationAndMenu(location, menuName);
	}
}
