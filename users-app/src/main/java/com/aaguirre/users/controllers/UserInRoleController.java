package com.aaguirre.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaguirre.users.entities.User;
import com.aaguirre.users.entities.UserInRole;
import com.aaguirre.users.services.UserInRoleService;

@RestController
@RequestMapping("/role/{roleId}/users")
public class UserInRoleController {
	
	@Autowired
	UserInRoleService userInRoleService;
	
	@GetMapping
	public ResponseEntity<List<User>> getUsersInRole(@PathVariable("roleId")Integer roleId){
		return new ResponseEntity<List<User>>(userInRoleService.findUsersInRole(roleId), HttpStatus.OK);
	}
	
	
	 @PostMapping("/{userId}")
	 public ResponseEntity<UserInRole> create(@PathVariable("roleId")Integer roleId, @PathVariable("userId") Integer userId){
		 return new ResponseEntity<UserInRole>(userInRoleService.create(roleId, userId), HttpStatus.CREATED);
	 }
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteUserInRole(@PathVariable("roleId")Integer roleId, @PathVariable("userId") Integer userId){
		userInRoleService.deleteUserInRole(roleId, userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
