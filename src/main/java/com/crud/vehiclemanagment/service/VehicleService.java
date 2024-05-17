package com.crud.vehiclemanagment.service;

import com.crud.vehiclemanagment.model.Vehicle;
import com.crud.vehiclemanagment.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private VehicleRepository repository;

    public VehicleRepository getRepository() {
        return repository;
    }

    @Autowired
    public void setRepository(VehicleRepository repository) {
        this.repository = repository;
    }

    public void addVehicle(Vehicle vehicle){

        repository.save(vehicle);
    }

    public List<Vehicle> getAllVehicle(){

        return repository.findAllVehicle();
    }
}
