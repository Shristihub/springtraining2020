package com.hotelapp.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Delivery {

	@Id
	@GeneratedValue(generator = "del_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name = "del_seq",sequenceName = "delivery_seq")
	private Integer deliveryId;
	private String deliveryName;
    private double charges;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="hotel_id")
    private Hotel hotel;
	public Delivery(String deliveryName, double charges) {
		super();
		this.deliveryName = deliveryName;
		this.charges = charges;
	}
	@Override
	public String toString() {
		return "Delivery [partnerName=" + deliveryName + ", charges=" + charges + "]";
	}	
	

}
