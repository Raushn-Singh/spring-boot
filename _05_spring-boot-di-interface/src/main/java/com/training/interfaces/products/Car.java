package com.training.interfaces.products;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class Car implements Vehicle{

	public Car() {
		System.out.println("new car is created ....");
	}
	@Override
	public String VehicleType() {
		// TODO Auto-generated method stub
		return " Car SUV ";
	}

}
