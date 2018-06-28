package com.inventory.vehicles.inventoryvehicles.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.vehicles.inventoryvehicles.model.Vehicle;
import com.inventory.vehicles.inventoryvehicles.service.VehicleInventoryService;

@RequestMapping(value = "/")
@RestController
public class VehicleInventoryController {

	@Autowired
	VehicleInventoryService vehicleInventoryService;

	Map<String, Vehicle> mapOfVehicles = new HashMap<String, Vehicle>();

	@RequestMapping(value = "vehicle", produces = { "application/json" }, method = RequestMethod.GET)
	public List<Vehicle> getAllVehicles() {

		List<Vehicle> listOfVehicles = vehicleInventoryService.findAll();

		/*
		 * for (Entry<String, Vehicle> entry : mapOfVehicles.entrySet()) {
		 * System.out.println("Key = " + entry.getKey() + ", Value = " +
		 * entry.getValue()); listOfVehicles.add(entry.getValue()); }
		 */
		return listOfVehicles;
	}

	@RequestMapping(value = "vehicle/{id}", produces = { "application/json" }, method = RequestMethod.GET)
	public Vehicle getVehicleByType(@PathVariable String id) {

		Vehicle vehicle = vehicleInventoryService.findById(Long.valueOf(id));

		/*
		 * Vehicle vehicle = mapOfVehicles.get(type+model); if(vehicle ==null) {
		 * return vehicle; }
		 */
		return vehicle;

	}

	@RequestMapping(value = "vehicle", consumes = { "application/json" }, produces = {
			"application/json" }, method = RequestMethod.POST)
	public void createVehicle(@RequestBody Vehicle vehicle) {

		vehicleInventoryService.insert(vehicle);

		/*
		 * mapOfVehicles.put(vehicle.getVehicleType()+vehicle.getVehicleModel(),
		 * vehicle); return
		 * mapOfVehicles.get(vehicle.getVehicleType()+vehicle.getVehicleModel())
		 * ;
		 */

	}

	@RequestMapping(value = "vehicle/{id}", produces = { "application/json" }, method = RequestMethod.DELETE)
	public void deleteVehicle(@PathVariable String id) {

		int deletedVehicle = vehicleInventoryService.deleteById(Long.valueOf(id));// mapOfVehicles.get(vehicle.getVehicleType()+vehicle.getVehicleModel());
		// mapOfVehicles.remove(deletedVehicle);
	}

	@RequestMapping(value = "vehicle", produces = { "application/json" }, method = RequestMethod.PUT)
	public int updateVehicle(@RequestBody Vehicle vehicle) {

		int updatedVehicle = vehicleInventoryService.update(vehicle);

		/*
		 * Vehicle updatedVehicle =
		 * mapOfVehicles.get(vehicle.getVehicleType()+vehicle.getVehicleModel())
		 * ; updatedVehicle.setPrice(vehicle.getPrice());
		 * updatedVehicle.setVehicleModel(vehicle.getVehicleModel());
		 * updatedVehicle.setVehicleType(vehicle.getVehicleType());
		 * updatedVehicle.setYear(vehicle.getYear());
		 * mapOfVehicles.put(updatedVehicle.getVehicleType()+updatedVehicle.
		 * getVehicleModel(), updatedVehicle);
		 */

		return updatedVehicle;

	}

}
