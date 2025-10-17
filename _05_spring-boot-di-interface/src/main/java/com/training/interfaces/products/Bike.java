package com.training.interfaces.products;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle{

	public Bike() {
		System.out.println("ne bike is created .....");
	}
	
	@Override
	public String VehicleType() {
		// TODO Auto-generated method stub
		return "This is bike";
	}

}
