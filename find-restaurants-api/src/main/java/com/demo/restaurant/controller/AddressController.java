package com.demo.restaurant.controller;

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

import com.demo.restaurant.exception.UserNotFoundException;
import com.demo.restaurant.model.Address;
import com.demo.restaurant.repository.AddressRepository;
import com.demo.restaurant.rest.responses.AddressResponse;
import com.demo.restaurant.service.AddressService;

@RestController
@RequestMapping("address") // http://localhost:8080/restaurents
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@GetMapping
	public List<Address> getAllAddress() {
		return addressService.getAllAddress();
	}
	
	@GetMapping(path="/{addressId}")
	public AddressResponse getAddress(@PathVariable Integer addressId) {
		return addressService.getAddress(addressId);
	}
	
	@PostMapping
	public AddressResponse createAddress(@RequestBody Address address) {
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
