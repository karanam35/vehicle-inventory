package com.inventory.vehicles.inventoryvehicles.service;

import java.util.List;

import com.inventory.vehicles.inventoryvehicles.model.Vehicle;

public interface VehicleInventoryService {
	
	public List<Vehicle> findAll() ;
	public Vehicle findById(long id);

	public int deleteById(long id) ;

	public int insert(Vehicle vehicle) ;

	public int update(Vehicle vehicle) ;

}
