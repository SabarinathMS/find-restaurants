package com.demo.restaurant.dao;

import java.util.List;

import com.demo.restaurant.model.Address;

public interface AddressDao {

	Address saveAddress(Address address);

	Address findAddressById(Integer id);

	void deleteAddressById(Integer addressId);

	void deleteAllAddress();

	List<Address> findAllAddress();

}
