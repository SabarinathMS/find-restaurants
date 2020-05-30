package com.demo.restaurant.service;

import java.util.List;

import com.demo.restaurant.model.Restaurant;
import com.demo.restaurant.rest.responses.RestaurantResponse;

public interface RestaurantService {
	RestaurantResponse createRestaurant(Restaurant restaurant);

	RestaurantResponse updateRestaurant(Restaurant restaurant);

	void deleteRestaurant(Integer restaurantId);

	void deleteAllRestaurant();

	List<Restaurant> getAllRestaurant();

	RestaurantResponse getRestaurant(Integer restaurantId);

}
