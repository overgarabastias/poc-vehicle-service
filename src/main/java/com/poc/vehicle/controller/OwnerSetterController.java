package com.poc.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.vehicle.entity.Owner;
import com.poc.vehicle.repository.OwnerRepository;
import com.poc.vehicle.to.OwnerTo;
import com.poc.vehicle.utils.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(tags = {"/poc/owners/setters"})
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/poc/owners/setters", produces="application/json;charset=UTF-8")
@Slf4j
public class OwnerSetterController {
	
	@Autowired
	private OwnerRepository ownerDb;
	
	@ApiOperation(value = "Crear vehiculo")
	@PostMapping(value="/create")
	public ResponseEntity<Owner> create(@RequestBody OwnerTo request){
		log.info("Call service /poc/owners/setters/create");
		ResponseEntity<Owner> response;
		try {
			
			Owner owner = new Owner();
			owner.setName(request.getName());
			owner.setEdad(request.getEdad());
			owner.setRut(request.getRut());
			owner.setStatus(Status.active);
			
			Owner ownerSave = ownerDb.save(owner);
			
			response = new ResponseEntity<Owner>(ownerSave, HttpStatus.OK);
			
			return response;
		} catch (Exception e) {
			log.error("Error en servicio: " + e.getMessage());
			response = new ResponseEntity<Owner>(HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}

}
