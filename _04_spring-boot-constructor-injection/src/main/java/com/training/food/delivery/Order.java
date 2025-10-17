package com.training.food.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Order {

	private int noOfProducts;
	private String emailId;
	
	private Product product;
	
	//ci : product object : Define constructor with that param
	
	//@Qualifier("productOne") : incorrect
//	@Autowired
	public Order(@Autowired @Qualifier("productOne") Product product) {
		System.out.println("Order created via 1 paamconstructor"+product);
		this.product=product;
	} 

	public int getNoOfProducts() {
		return noOfProducts;
	}

	public void setNoOfProducts(int noOfProducts) {
		this.noOfProducts = noOfProducts;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
