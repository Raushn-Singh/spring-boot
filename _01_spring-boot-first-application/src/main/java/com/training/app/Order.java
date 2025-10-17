package com.training.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.lms.app.Product;

@Component
public class Order {
    @Autowired
	Product product;
    public  Order() {
		System.out.println("Order is created");
	}
	public Product getProduct() {
		return product;
	}
    
}
