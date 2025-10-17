package com.training.lms.delivey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderDetails {

	private double orderAmount;
	private String userEmail;
// 	@Qualifier("cartItems2")
	@Autowired
	private CartItems cartItems;
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public CartItems getCartItems() {
		return cartItems;
	}
	public void setCartItems(CartItems cartItems) {
		this.cartItems = cartItems;
	}
	
}
