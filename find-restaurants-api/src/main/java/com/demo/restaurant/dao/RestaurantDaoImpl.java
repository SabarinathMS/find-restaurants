package com.demo.restaurant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.restaurant.model.Restaurant;
import com.demo.restaurant.repository.RestaurantRepository;

@Repository
public class RestaurantDaoImpl implements RestaurantDao{

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	public Restaurant saveRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}
	
	@Override
	public Restaurant findRestaurantById(Integer restaurantId) {
		return restaurantRepository.getOne(restaurantId);
	}
	
	@Override
	public List<Restaurant> findAllRestaurants() {
		return restaurantRepository.findAll();
	}
	
	@Override
	public void deleteRestaurantById(Integer restaurantId) {
		restaurantRepository.deleteById(restaurantId);
	}
	
	@Override
	public void deleteAllRestaurants() {
		restaurantRepository.deleteAll();
	}

}
