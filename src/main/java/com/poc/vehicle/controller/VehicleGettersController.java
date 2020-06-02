package com.poc.vehicle.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Api(description = "Servicio para administrar ejecutar un comando de ansible para levantar maquinas", tags = {"/ansible/setters"})
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/ansible/setters", produces="application/json;charset=UTF-8")
@Slf4j
public class VehicleGettersController {

}
