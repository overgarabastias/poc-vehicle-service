package com.poc.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.vehicle.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
