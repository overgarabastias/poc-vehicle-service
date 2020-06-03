package com.poc.vehicle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.poc.vehicle.utils.Status;
import com.poc.vehicle.utils.TypeVahicle;

import lombok.Data;

@Entity
@Data
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
	
	@ManyToOne
	@JoinColumn(name="ownerId")
	private Owner owner;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status;

}
