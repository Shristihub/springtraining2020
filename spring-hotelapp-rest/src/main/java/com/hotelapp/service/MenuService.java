package com.hotelapp.service;

import java.util.List;

import com.hotelapp.bean.Menu;

public interface MenuService {

	List<Menu> getMenusByHotel(String hotelname);
	List<Menu> getMenusByCost(double min, double max);
	void updateMenuInHotel(Menu menu, int hotelId);
	void deleteMenuInHotel(int hotelId);
}
