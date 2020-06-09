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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.restaurant.model.Address;
import com.demo.restaurant.rest.responses.AddressResponse;
import com.demo.restaurant.rest.responses.RestaurantResponse;
import com.demo.restaurant.service.AddressService;
import com.demo.restaurant.service.RestaurantService;

@RestController
@RequestMapping("address") // http://localhost:8080/address
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping
	public List<AddressResponse> getAddress() {
		return addressService.getAllAddress();
	}
	
	@GetMapping(path="/findRestaurant")
	public List<AddressResponse> getAllAddressByLatLng(@RequestParam String lat, @RequestParam String lng) {
		return addressService.getAllAddress(lat,lng);
	}
	
	@GetMapping(path="/{addressId}")
	public AddressResponse getAddress(@PathVariable Integer addressId) {
		return addressService.getAddress(addressId);
	}
	
	@PostMapping(path="/{restaurantId}/address")
	public AddressResponse createAddress(@PathVariable Integer restaurantId, @RequestBody Address address) {
		RestaurantResponse restaurant = restaurantService.getRestaurant(restaurantId);
		address.setRestaurant(restaurant);
		return addressService.createAddress(address);
	}
	
	@PutMapping
	public AddressResponse updateAddress(@RequestBody Address address) {
		return addressService.updateAddress(address);
	}
	
	@DeleteMapping(path="/{addressId}")
	public void deleteAddress(@PathVariable Integer addressId) {
		addressService.deleteAddress(addressId);
	}
	
	@DeleteMapping
	public void deleteAllAddress(@PathVariable Integer addressId) {
		addressService.deleteAllAddress();
	}
	
	
}
