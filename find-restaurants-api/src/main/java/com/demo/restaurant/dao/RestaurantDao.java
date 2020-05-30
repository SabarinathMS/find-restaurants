package com.demo.restaurant.dao;

import java.util.List;

import com.demo.restaurant.model.Restaurant;

public interface RestaurantDao {
	Restaurant saveRestaurant(Restaurant restaurant);

	Restaurant findRestaurantById(Integer restaurantId);

	List<Restaurant> findAllRestaurants();

	void deleteRestaurantById(Integer restaurantId);

	void deleteAllRestaurants();

}
