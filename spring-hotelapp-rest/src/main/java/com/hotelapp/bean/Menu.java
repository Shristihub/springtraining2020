package com.hotelapp.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Menu {

	@Id
	@GeneratedValue(generator = "menu_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name = "menu_seq",sequenceName = "menu_seq")
	private Integer menuId;
	private String menuName;
	private double cost;
	@ManyToMany(mappedBy = "menuList")
	private Set<Hotel> hotelList = new HashSet<>();
	public Menu(String menuName, double cost) {
		super();
		this.menuName = menuName;
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Menu [menuName=" + menuName + ", cost=" + cost + "]";
	}
	

}
