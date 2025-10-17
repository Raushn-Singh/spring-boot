package com.training.interfaces.products;

import org.springframework.stereotype.Component;

@Component
public class Bus implements Vehicle {

	public Bus() {
		System.out.println("new bus is created ...");
	}
	
	@Override
	public String VehicleType() {
		// TODO Auto-generated method stub
		return "this is bus";
	}

}
