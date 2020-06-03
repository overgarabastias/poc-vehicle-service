package com.poc.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.vehicle.entity.Vehicle;
import com.poc.vehicle.repository.VehicleRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(description = "Servicio para administrar ejecutar un comando de ansible para levantar maquinas", tags = {"/poc/vehicles/getters"})
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/poc/vehicles/getters", produces="application/json;charset=UTF-8")
@Slf4j
public class VehicleGettersController {
	
	@Autowired
	private VehicleRepository vehicleDb;
	
	@ApiOperation(value = "Obtener todos los vehiculos")
	@GetMapping(value="/getAll")
	public ResponseEntity<List<Vehicle>> getAll(){
		log.info("Call service /poc/vehicles/getters/getAll");
		ResponseEntity<List<Vehicle>> response;
		try {
			List<Vehicle> vehicles = vehicleDb.findAll();
			response = new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
			return response;
		} catch (Exception e) {
			log.error("Error en servicio: " + e.getMessage());
			response = new ResponseEntity<List<Vehicle>>(HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}
	
	@ApiOperation(value = "Obtener un vehiculo por id")
	@GetMapping(value="/getById")
	public ResponseEntity<Vehicle> getById(@RequestParam(name = "id", required = true) Long id){
		log.info("Call service /poc/vehicles/getters/getById");
		ResponseEntity<Vehicle> response;
		try {
			Vehicle vehicle = vehicleDb.findById(id).get();
			response = new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
			return response;
		} catch (Exception e) {
			log.error("Error en servicio: " + e.getMessage());
			response = new ResponseEntity<Vehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}
}
