package com.poc.vehicle.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.poc.vehicle.utils.Status;

import lombok.Data;

@Entity
@Data
public class Owner {
	
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
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status;
	
}
