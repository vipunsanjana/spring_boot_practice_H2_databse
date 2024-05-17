package com.crud.vehiclemanagment;

import com.crud.vehiclemanagment.model.Vehicle;
import com.crud.vehiclemanagment.service.VehicleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class VehiclemanagmentApplication {

	public static void main(String[] args) {


		ApplicationContext context =  SpringApplication.run(VehiclemanagmentApplication.class, args);


		Vehicle vehicle = context.getBean(Vehicle.class);
		vehicle.setRegNumber(456);
		vehicle.setVehicleType("SUV");
		vehicle.setBrand("Toyota");
		vehicle.setModel("V8");

		VehicleService service = context.getBean(VehicleService.class);

		service.addVehicle(vehicle);

		List<Vehicle> vehicles = service.getAllVehicle();
		System.out.println(vehicles);

	}

}
