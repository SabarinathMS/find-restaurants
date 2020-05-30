package com.demo.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.restaurant.model.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{

}
