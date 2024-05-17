package com.crud.vehiclemanagment.repository;

import com.crud.vehiclemanagment.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class VehicleRepository {

    private JdbcTemplate connection;

    public JdbcTemplate getConnection() {
        return connection;
    }

    @Autowired
    public void setConnection(JdbcTemplate connection) {
        this.connection = connection;
    }

    public void save(Vehicle vehicle){

        String query = "INSERT INTO vehicle(regNumber,vehicleType,brand,model) VALUES(?,?,?,?)";

        int count = connection.update(query,vehicle.getRegNumber(),vehicle.getVehicleType(),vehicle.getBrand(),vehicle.getModel());
        System.out.println(count+"vehicle(s) saved......");

    }


    public List<Vehicle> findAllVehicle(){

        String query = "SELECT * FROM vehicle";

        RowMapper<Vehicle> rowMapper = new RowMapper<Vehicle>() {
            @Override
            public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {

                Vehicle vehicle = new Vehicle();
                vehicle.setRegNumber(rs.getInt("regNumber"));
                vehicle.setVehicleType(rs.getString("vehicleType"));
                vehicle.setBrand(rs.getString("brand"));
                vehicle.setModel(rs.getString("model"));

                return vehicle;
            }
        };

        List<Vehicle> vehicleList = connection.query(query, rowMapper);
        return vehicleList;

    }

}
