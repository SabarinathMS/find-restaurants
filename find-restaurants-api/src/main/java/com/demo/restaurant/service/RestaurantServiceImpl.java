package com.demo.restaurant.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.restaurant.dao.RestaurantDao;
import com.demo.restaurant.exception.UserNotFoundException;
import com.demo.restaurant.model.Restaurant;
import com.demo.restaurant.rest.responses.RestaurantResponse;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	RestaurantDao restaurantDao;
	
	@Override
	public RestaurantResponse createRestaurant(Restaurant restaurant) {
		restaurant = restaurantDao.saveRestaurant(restaurant);
		RestaurantResponse restaurantResponse = new RestaurantResponse();
		BeanUtils.copyProperties(restaurant, restaurantResponse);
		return restaurantResponse;
	}
	
	@Override
	public RestaurantResponse updateRestaurant(Restaurant restaurant) {
		Restaurant restaurantresponse = restaurantDao.findRestaurantById(restaurant.getId()); 
		if(restaurantresponse == null) {
			throw new UserNotFoundException("id = "+restaurant.getId());
		}
		restaurant = restaurantDao.saveRestaurant(restaurant);
		RestaurantResponse restaurantResponse = new RestaurantResponse();
		BeanUtils.copyProperties(restaurant, restaurantResponse);
		return restaurantResponse;
	}

	@Override
	public void deleteRestaurant(Integer restaurantId) {
		restaurantDao.deleteRestaurantById(restaurantId);
	}

	@Override
	public void deleteAllRestaurant() {
		restaurantDao.deleteAllRestaurants();
	}

	@Override
	public RestaurantResponse getRestaurant(Integer restaurantId) {
		Restaurant restaurant = restaurantDao.findRestaurantById(restaurantId);
		if(restaurant == null) {
			throw new UserNotFoundException("id-"+restaurantId);
		}
		RestaurantResponse restaurantResponse = new RestaurantResponse();
		BeanUtils.copyProperties(restaurant, restaurantResponse);
		return restaurantResponse;
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		return restaurantDao.findAllRestaurants();
	}

}
