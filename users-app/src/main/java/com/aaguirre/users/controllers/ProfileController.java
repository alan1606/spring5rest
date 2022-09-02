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

import com.aaguirre.users.entities.Profile;
import com.aaguirre.users.services.ProfileService;

@RestController
@RequestMapping("/users/{userId}/profile")
public class ProfileController {

	@Autowired
	ProfileService service;
	
	@GetMapping("/{profileId}")
	public ResponseEntity<?> getByUserIdAndProfileId(@PathVariable("userId") Integer userId, @PathVariable("profileId") Integer profileId){
		return new ResponseEntity<Profile>(service.findByUserIdAndProfileId(userId, profileId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Profile> create(@PathVariable("userId") Integer userId, @RequestBody Profile profile){
		return new ResponseEntity<Profile>(service.create(profile, userId), HttpStatus.CREATED);
	}
	
}
