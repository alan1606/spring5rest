package com.aaguirre.users.controllers;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aaguirre.users.entities.User;
import com.aaguirre.users.services.UserService;

import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping
	@Timed("get.users")
	public ResponseEntity<Page<User>> getUsers(@RequestParam(required = false, value = "page", defaultValue = "0") int page, 
											   @RequestParam(required = false, value = "size", defaultValue = "100") int size){
		return new ResponseEntity<Page<User>>(service.getUsers(page, size), HttpStatus.OK);
	} 
	
	@GetMapping("/usernames")
	public ResponseEntity<Page<String>> getUsernames(@RequestParam(required = false, value = "page", defaultValue = "0") int page, 
			   										 @RequestParam(required = false, value = "size", defaultValue = "100") int size){
		return new ResponseEntity<Page<String>>(service.getUsernames(page, size), HttpStatus.OK);
	} 
	
	@GetMapping("/{userId}")
	@ApiOperation(value = "Returns a user for the given user id", response = User.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Record was found"),
			@ApiResponse(code = 400, message = "Record was not found")
	})
	public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId){
		return new ResponseEntity<User>(service.getUserById(userId), HttpStatus.OK);
	}
	
	@GetMapping("/username/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username){
		return new ResponseEntity<User>(service.getUserByUsername(username), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> authenticate(@RequestBody User user){
		return new ResponseEntity<User>(service.getUserByUsernameAndPassword(user.getUsername(), user.getPassword()), HttpStatus.OK);
	}
	
	@DeleteMapping("/username/{username}")
	public ResponseEntity<Void> deleteUser(@PathVariable("username") String username){
		service.deleteUserByUsername(username);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
