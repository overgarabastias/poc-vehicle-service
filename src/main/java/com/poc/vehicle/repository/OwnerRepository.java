package com.poc.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.vehicle.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
	
}
