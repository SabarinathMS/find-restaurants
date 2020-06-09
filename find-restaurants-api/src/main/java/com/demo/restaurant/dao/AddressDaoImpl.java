package com.demo.restaurant.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.restaurant.model.Address;
import com.demo.restaurant.repository.AddressRepository;

@Repository
public class AddressDaoImpl implements AddressDao{

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}
	
	@Override
	public Address findAddressById(Integer addressId) {
		return addressRepository.getOne(addressId);
	}
	
	@Override
	public List<Address> findAllAddress(Double lat, Double lng) {
		return addressRepository.findByLatLng(lat,lng);
	}
	
	@Override
	public void deleteAddressById(Integer addressId) {
		addressRepository.deleteById(addressId);
	}
	
	@Override
	public void deleteAllAddress() {
		addressRepository.deleteAll();
	}

	@Override
	public List<Address> findAllAddress() {
		// TODO Auto-generated method stub
		return addressRepository.findAll();
	}

}
