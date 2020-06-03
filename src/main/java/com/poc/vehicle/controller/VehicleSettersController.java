package com.poc.vehicle.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.vehicle.entity.Owner;
import com.poc.vehicle.entity.Vehicle;
import com.poc.vehicle.repository.OwnerRepository;
import com.poc.vehicle.repository.VehicleRepository;
import com.poc.vehicle.to.VehicleTo;
import com.poc.vehicle.utils.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(tags = {"/poc/vehicles/setters"})
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/poc/vehicles/setters", produces="application/json;charset=UTF-8")
@Slf4j
public class VehicleSettersController {
	
	@Autowired
	private VehicleRepository vehicleDb;
	
	@Autowired
	private OwnerRepository ownerDb;
	
	@ApiOperation(value = "Crear vehiculo")
	@PostMapping(value="/create")
	public ResponseEntity<Vehicle> create(@RequestBody VehicleTo request){
		log.info("Call service /poc/vehicles/setters/create");
		ResponseEntity<Vehicle> response;
		try {
			
			Vehicle vehicle = new Vehicle();
			
			Owner owner = ownerDb.findById(request.getOwnerId()).get();
			
			vehicle.setModel(request.getModel());
			vehicle.setType(request.getType());
			vehicle.setOwner(owner);
			vehicle.setStatus(Status.active);
			
			Vehicle vehicleSave = vehicleDb.save(vehicle);
			
			response = new ResponseEntity<Vehicle>(vehicleSave, HttpStatus.OK);
			
			return response;
		} catch (Exception e) {
			log.error("Error en servicio: " + e.getMessage());
			response = new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}
	
	
	@ApiOperation(value = "Crear o actualizar un vehiculo")
	@DeleteMapping(value="/delete")
	public ResponseEntity<Vehicle> delete(@RequestParam(name = "id", required = true) Long id){
		log.info("Call service /poc/vehicles/setters/delete");
		ResponseEntity<Vehicle> response;
		try {
			
			Optional<Vehicle> vehicleOp = vehicleDb.findById(id);
			if (vehicleOp.isPresent()) {
				Vehicle vehicle = vehicleOp.get();
				vehicle.setStatus(Status.delete);
				
				Vehicle vehicleSave = vehicleDb.save(vehicle);
				
				response = new ResponseEntity<Vehicle>(vehicleSave, HttpStatus.OK);
				
				return response;
			}else {
				response = new ResponseEntity<Vehicle>(HttpStatus.BAD_REQUEST);
			
				return response;
			}
			
		} catch (Exception e) {
			log.error("Error en servicio: " + e.getMessage());
			response = new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}
	
	@ApiOperation(value = "Crear o actualizar un vehiculo")
	@PutMapping(value="/restore")
	public ResponseEntity<Vehicle> restore(@RequestParam(name = "id", required = true) Long id){
		log.info("Call service /poc/vehicles/setters/restore");
		ResponseEntity<Vehicle> response;
		try {
			
			Optional<Vehicle> vehicleOp = vehicleDb.findById(id);
			if (vehicleOp.isPresent()) {
				
				Vehicle vehicle = vehicleOp.get();
				
				vehicle.setStatus(Status.active);
				
				Vehicle vehicleSave = vehicleDb.save(vehicle);
				
				response = new ResponseEntity<Vehicle>(vehicleSave, HttpStatus.OK);
				
				return response;
			}else {
				
				response = new ResponseEntity<Vehicle>(HttpStatus.BAD_REQUEST);
			
				return response;
			}
			
		} catch (Exception e) {
			log.error("Error en servicio: " + e.getMessage());
			response = new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}
}
