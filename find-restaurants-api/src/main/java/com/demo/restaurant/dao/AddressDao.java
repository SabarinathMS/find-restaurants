package com.demo.restaurant.dao;

import java.util.List;

import com.demo.restaurant.model.Address;
import com.demo.restaurant.rest.responses.AddressResponse;

public interface AddressDao {

	Address saveAddress(Address address);

	Address findAddressById(Integer id);

	void deleteAddressById(Integer addressId);

	void deleteAllAddress();

	List<Address> findAllAddress(Double lat, Double lng);

	List<Address> findAllAddress();

}
