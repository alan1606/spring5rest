package com.aaguirre.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaguirre.users.entities.Address;
import com.aaguirre.users.services.AddressService;

@RestController
@RequestMapping("/users/{userId}/profile/{profileId}/addresses")
public class AddressesController {

	@Autowired
	private AddressService addressService;
	
	@GetMapping
	public ResponseEntity<List<Address>> findByUserIdAndProfileId(@PathVariable("userId") Integer userId, @PathVariable("profileId") Integer profileId){
		return new ResponseEntity<List<Address>>(addressService. findByUserIdAndProfileId(userId, profileId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Address> create(@PathVariable("userId") Integer userId, @PathVariable("profileId") Integer profileId, @RequestBody Address address){
		return new ResponseEntity<Address>(addressService.create(userId, profileId, address), HttpStatus.CREATED);
	}
}
