package com.training.springboot.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Scope(value = "prototype")
@Component
public class Product {

	private int productId;
	private String productName;
	private double price;
	
	public Product() {
		super();
		System.out.println("Product one is created");
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
