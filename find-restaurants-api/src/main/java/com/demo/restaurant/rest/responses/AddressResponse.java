package com.demo.restaurant.rest.responses;

import com.demo.restaurant.model.Address;
import com.demo.restaurant.model.Restaurant;

public class AddressResponse extends Address{
	private Restaurant restaurantDetails;

	public Restaurant getRestaurantDetails() {
		return restaurantDetails;
	}

	public void setRestaurantDetails(Restaurant restaurantDetails) {
		this.restaurantDetails = restaurantDetails;
	}
	
	
}
