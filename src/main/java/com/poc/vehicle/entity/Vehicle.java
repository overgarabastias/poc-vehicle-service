package com.poc.vehicle.entity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.poc.vehicle.utils.TypeVahicle;

public class Vehicle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
	private Long id;
	
	@Column(name="model")
	private String model;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private TypeVahicle type;
	
	@OneToOne
	@JoinColumn(name="driverId")
	private driver driver;

}
