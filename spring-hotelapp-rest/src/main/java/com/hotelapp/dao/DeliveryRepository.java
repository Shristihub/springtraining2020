package com.hotelapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelapp.bean.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{


}
