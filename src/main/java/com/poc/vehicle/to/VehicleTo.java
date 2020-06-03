package com.poc.vehicle.to;

import com.poc.vehicle.utils.TypeVahicle;

import lombok.Data;

@Data
public class VehicleTo {
	
	private String model;
	private TypeVahicle type;
	private Long ownerId;
	
}
