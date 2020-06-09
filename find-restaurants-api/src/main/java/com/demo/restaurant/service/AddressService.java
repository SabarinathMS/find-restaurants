package com.demo.restaurant.service;

import java.util.List;

import com.demo.restaurant.model.Address;
import com.demo.restaurant.rest.responses.AddressResponse;

public interface AddressService {
	AddressResponse createAddress(Address Address);

	AddressResponse updateAddress(Address Address);

	void deleteAddress(Integer AddressId);

	void deleteAllAddress();

	AddressResponse getAddress(Integer AddressId);
	
	List<AddressResponse> getAllAddress(String lat, String lng );

	List<AddressResponse> getAllAddress(); 
}
