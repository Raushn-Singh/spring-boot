package com.training.interfaces.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component //tocreate an object of the class
public class Garrage {
	// DI : Via Interface
//	@Qualifier("bike")
//	@Qualifier("car2")
    @Autowired
	private Vehicle vehicle;
	public Garrage() {
		System.out.println("garrage is creted");
	}
	
	public Garrage(Vehicle vehicle) {
		super();
		this.vehicle = vehicle;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
}
