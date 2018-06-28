package com.inventory.vehicles.inventoryvehicles.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.vehicles.inventoryvehicles.dao.VehicleRepository;
import com.inventory.vehicles.inventoryvehicles.model.Vehicle;
import com.inventory.vehicles.inventoryvehicles.service.VehicleInventoryService;

@Service
public class VehicleInventoryServiceImpl implements VehicleInventoryService{
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}

	public Vehicle findById(long id) {
		return vehicleRepository.findById(id);
	}

	public int deleteById(long id) {
		return vehicleRepository.deleteById(id);
	}

	public int insert(Vehicle vehicle) {
		return vehicleRepository.insert(vehicle);
	}

	public int update(Vehicle vehicle) {
		return vehicleRepository.update(vehicle);
	}

}
