package com.hotelapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelapp.bean.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>{
}
