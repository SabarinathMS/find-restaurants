package com.demo.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.restaurant.model.Restaurant;
import com.demo.restaurant.rest.responses.RestaurantResponse;
import com.demo.restaurant.service.RestaurantService;

@RestController
@RequestMapping("restaurants") // http://localhost:8080/restaurants
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;
	
	@GetMapping
	public List<Restaurant> getAllRestaurant() {
		return restaurantService.getAllRestaurant();
	}
	
	@GetMapping(path="/{restaurantId}")
	public RestaurantResponse getRestaurant(@PathVariable Integer restaurantId) {
		return restaurantService.getRestaurant(restaurantId);
	}
	
	@PostMapping
	public RestaurantResponse createRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantService.createRestaurant(restaurant);
	}
	
	@PutMapping
	public RestaurantResponse updateRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantService.updateRestaurant(restaurant);
	}
	
	@DeleteMapping(path="/{restaurantId}")
	public void deleteRestaurant(@PathVariable Integer restaurantId) {
		restaurantService.deleteRestaurant(restaurantId);
	}
	
	@DeleteMapping
	public void deleteAllRestaurant() {
		restaurantService.deleteAllRestaurant();
	}
}
