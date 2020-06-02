package com.poc.vehicle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class driver {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="edad")
	private int edad;
	
	@Column(name="rut")
	private String rut;
	
}
