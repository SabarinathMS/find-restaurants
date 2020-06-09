package com.demo.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.restaurant.model.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{
	 @Query(value= "SELECT *, ( 6367 * acos( cos( radians(?1) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - radians(?2) ) + sin( radians(?1) ) * sin( radians( latitude ) ) ) ) AS distance FROM address HAVING distance < 1 ORDER BY distance", nativeQuery = true)
	 List<Address> findByLatLng(Double lat, Double lng);
	 
	 @Query(value= "SELECT * from Address", nativeQuery = true)
	 List<Address> getAllAddress();

}
