package com.training.lms.delivey;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component("cartItems1")
public class CartItems {

	private int noOfItems;
	private ArrayList<String> itemNames;
	
	public CartItems() {
		
	}
	
	public CartItems(int noOfItems, ArrayList<String> itemNames) {
		super();
		this.noOfItems = noOfItems;
		this.itemNames = itemNames;
	}

	public int getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}
	public ArrayList<String> getItemNames() {
		return itemNames;
	}
	public void setItemNames(ArrayList<String> itemNames) {
		this.itemNames = itemNames;
	} 
    
}