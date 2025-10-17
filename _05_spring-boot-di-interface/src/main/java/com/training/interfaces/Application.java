package com.training.interfaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.training.interfaces.products.Car;
import com.training.interfaces.products.Garrage;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		Garrage garrage = context.getBean("garrage",Garrage.class);
		System.out.println(garrage);
		System.out.println(garrage.getVehicle());
		System.out.println(garrage.getVehicle().getClass());
		System.out.println(garrage.getVehicle().VehicleType());
	}

//	@Bean
//	public Car car2() {
//		return new Car(); 
//	}
}
