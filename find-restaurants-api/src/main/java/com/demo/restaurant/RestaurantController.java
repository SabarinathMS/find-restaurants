package com.demo.restaurant;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@RestController
@RequestMapping("restaurants") // http://localhost:8080/restaurants
public class RestaurantController {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@GetMapping
	public List<Restaurant> getAllRestaurant() {
		return restaurantRepository.findAll();
	}
	
	@GetMapping(path="/{restaurantId}")
	public RestaurantResponse getRestaurant(@PathVariable Integer restaurantId) {
		Restaurant restaurant =restaurantRepository.getOne(restaurantId);
		if(restaurant == null) {
			throw new UserNotFoundException("id-"+restaurantId);
		}
		RestaurantResponse restaurantResponse = new RestaurantResponse();
		BeanUtils.copyProperties(restaurant, restaurantResponse);
		return restaurantResponse;
	}
	
	@PostMapping
	public RestaurantResponse createRestaurant(@RequestBody Restaurant restaurant) {
		RestaurantResponse restaurantResponse = new RestaurantResponse();
		restaurant = restaurantRepository.save(restaurant);
		BeanUtils.copyProperties(restaurant, restaurantResponse);
		return restaurantResponse;
	}
	
	@PutMapping
	public RestaurantResponse updateRestaurant(@RequestBody Restaurant restaurant) {
		Restaurant restaurantresponse = restaurantRepository.getOne(restaurant.getId()); 
		if(restaurantresponse == null) {
			throw new UserNotFoundException("id = "+restaurant.getId());
		}
		restaurant = restaurantRepository.save(restaurant);
		RestaurantResponse restaurantResponse = new RestaurantResponse();
		BeanUtils.copyProperties(restaurant, restaurantResponse);
		return restaurantResponse;
	}
	
	@DeleteMapping(path="/{restaurantId}")
	public void deleteRestaurant(@PathVariable Integer restaurantId) {
		restaurantRepository.deleteById(restaurantId);
	}
}
