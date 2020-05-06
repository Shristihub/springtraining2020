package com.hotelapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotelapp.bean.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{
	
	List<Hotel> findByAddressLocation(String location);
    
	@Query("from Hotel h inner join h.menuList m where m.menuName=?1 ")
	List<Hotel> findByMenus(String menuName);
    
    @Query("from Hotel h inner join h.delivery d where d.deliveryName=?1 ")
	List<Hotel> findByDelivery(String delivery);
    
}
