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
@RequestMapping("address") // http://localhost:8080/restaurents
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;
	
	@GetMapping
	public List<Address> getAllAddress() {
		return addressRepository.findAll();
	}
	
	@GetMapping(path="/{addressId}")
	public AddressResponse getRestaurent(@PathVariable Integer addressId) {
		Address addresss =addressRepository.getOne(addressId);
		if(addresss == null) {
			throw new UserNotFoundException("id-"+addressId);
		}
		AddressResponse addressResponse = new AddressResponse();
		BeanUtils.copyProperties(addresss, addressResponse);
		return addressResponse;
	}
	
	@PostMapping
	public AddressResponse createRestaurent(@RequestBody Address address) {
		AddressResponse addressResponse = new AddressResponse();
		address = addressRepository.save(address);
		BeanUtils.copyProperties(address, addressResponse);
		return addressResponse;
	}
	
	@PutMapping
	public AddressResponse updateRestaurent(@RequestBody Address address) {
		Address addressresponse = addressRepository.getOne(address.getId()); 
		if(addressresponse == null) {
			throw new UserNotFoundException("id = "+address.getId());
		}
		address = addressRepository.save(address);
		AddressResponse addressResponse = new AddressResponse();
		BeanUtils.copyProperties(address, addressResponse);
		return addressResponse;
	}
	
	@DeleteMapping(path="/{addressId}")
	public void deleteRestaurent(@PathVariable Integer addressId) {
		addressRepository.deleteById(addressId);
	}
}
