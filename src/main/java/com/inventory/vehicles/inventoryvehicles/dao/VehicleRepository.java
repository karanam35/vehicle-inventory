package com.inventory.vehicles.inventoryvehicles.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.inventory.vehicles.inventoryvehicles.model.Vehicle;

@Repository
public class VehicleRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	class VehicleRowMapper implements RowMapper<Vehicle> {
		@Override
		public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Vehicle vehicle = new Vehicle();
			vehicle.setId(rs.getLong("id"));
			vehicle.setVehicleType(rs.getString("vehicleType"));
			vehicle.setVehicleModel(rs.getString("vehicleModel"));
			vehicle.setPrice(rs.getString("price"));
			vehicle.setYear(rs.getString("year"));
			return vehicle;
		}

	}

	public List<Vehicle> findAll() {
		return jdbcTemplate.query("select * from vehicle", new VehicleRowMapper());
	}

	public Vehicle findById(long id) {
		return jdbcTemplate.queryForObject("select * from vehicle where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Vehicle>(Vehicle.class));
	}

	public int deleteById(long id) {
		return jdbcTemplate.update("delete from vehicle where id=?", new Object[] { id });
	}

	public int insert(Vehicle vehicle) {
		return jdbcTemplate.update("insert into vehicle (id, vehicleType, vehicleModel, price, year) " + "values(?,  ?, ?,?,?)",
				new Object[] { vehicle.getId(), vehicle.getVehicleType(), vehicle.getVehicleModel(),vehicle.getPrice(), vehicle.getYear()  });
	}

	public int update(Vehicle vehicle) {
		return jdbcTemplate.update("update vehicle " + " set vehicleType = ?, vehicleModel = ?, price=?, year=? " + " where id = ?",
				new Object[] {vehicle.getId(), vehicle.getVehicleType(), vehicle.getVehicleModel(),vehicle.getPrice(), vehicle.getYear()  });
	}

}