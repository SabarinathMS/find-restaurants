package com.demo.restaurant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.restaurant.dao.AddressDao;
import com.demo.restaurant.exception.UserNotFoundException;
import com.demo.restaurant.model.Address;
import com.demo.restaurant.rest.responses.AddressResponse;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressDao addressDao;
	
	@Autowired
	RestaurantService restaurantService;
	
	@Override
	public AddressResponse createAddress(Address address) {
		address = addressDao.saveAddress(address);
		AddressResponse addressResponse = new AddressResponse();
		BeanUtils.copyProperties(address, addressResponse);
		return addressResponse;
	}
	
	@Override
	public AddressResponse updateAddress(Address address) {
		Address addressresponse = addressDao.findAddressById(address.getId()); 
		if(addressresponse == null) {
			throw new UserNotFoundException("id = "+address.getId());
		}
		address = addressDao.saveAddress(address);
		AddressResponse addressResponse = new AddressResponse();
		BeanUtils.copyProperties(address, addressResponse);
		return addressResponse;
	}

	@Override
	public void deleteAddress(Integer addressId) {
		addressDao.deleteAddressById(addressId);
	}

	@Override
	public void deleteAllAddress() {
		addressDao.deleteAllAddress();
	}

	@Override
	public AddressResponse getAddress(Integer addressId) {
		Address address = addressDao.findAddressById(addressId);
		if(address == null) {
			throw new UserNotFoundException("id-"+addressId);
		}
		AddressResponse addressResponse = new AddressResponse();
		BeanUtils.copyProperties(address, addressResponse);
		return addressResponse;
	}

	@Override
	public List<AddressResponse> getAllAddress(String lat, String lng) {
		List<Address> addressList =  addressDao.findAllAddress(Double.parseDouble(lat), Double.parseDouble(lng));
		List<AddressResponse> addressResponses = new ArrayList<>();
		for(Address add: addressList) {
			AddressResponse addressResponse = new AddressResponse();
			BeanUtils.copyProperties(add, addressResponse);
			addressResponse.setRestaurantDetails(restaurantService.getRestaurant(add.getRestaurant().getId()));
			addressResponses.add(addressResponse);
		}
		return addressResponses;
	}

	@Override
	public List<AddressResponse> getAllAddress() {
		List<Address> addressList =  addressDao.findAllAddress();
		List<AddressResponse> addressResponses = new ArrayList<>();
		for(Address add: addressList) {
			AddressResponse addressResponse = new AddressResponse();
			BeanUtils.copyProperties(add, addressResponse);
			addressResponse.setRestaurantDetails(restaurantService.getRestaurant(add.getRestaurant().getId()));
			addressResponses.add(addressResponse);
		}
		return addressResponses;
	}
}

