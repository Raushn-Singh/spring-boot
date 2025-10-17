package com.training.food.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Order {

	private int noOfProducts;
	private String email;
	
	// @Autowired -> field injection
	private Product product;
	public Order() {
		System.out.println("Order is created via default constructor;");
	}
	public int getNoOfProducts() {
		return noOfProducts;
	}
	public void setNoOfProducts(int noOfProducts) {
		this.noOfProducts = noOfProducts;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Product getProduct() {
		return product;
	}
	// this is method 
	// stter method arg name :product
	// brean Id : productOne,productTwo -> failed
	// bean Id : product , productTwo 
	//@Qualifier("productTwo") 
	@Autowired
	public void setProduct( @Qualifier("productTwo") Product product) {
		this.product = product;
	}

	
}
