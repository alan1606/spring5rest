package com.aaguirre.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aaguirre.users.entities.Role;
import com.aaguirre.users.entities.User;
import com.aaguirre.users.entities.UserInRole;
import com.aaguirre.users.repositories.RoleRepository;
import com.aaguirre.users.repositories.UserInRoleRepository;

@Service
public class UserInRoleService {

	@Autowired
	private UserInRoleRepository userInRoleRepository;
	
	@Autowired 
	private RoleRepository roleRepository;
	
	public List<User> findUsersInRole(Integer roleId) {
		Optional<Role> result = roleRepository.findById(roleId);
		if(result.isPresent()) {
			return userInRoleRepository.findByRoleId(roleId);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role %d not found", roleId));
	}
	
	private Optional<UserInRole> findByRoleIdAndUserId(Integer roleId, Integer userId) {
		return userInRoleRepository.findByRoleIdAndUserId(roleId, userId);
	}

	public UserInRole create(Integer roleId, Integer userId) {
		Optional<UserInRole> result = this.findByRoleIdAndUserId(roleId, userId);
		if(result.isEmpty()) {
			UserInRole temp = new UserInRole();
			User tempUser = new User();
			Role tempRole = new Role();
			tempUser.setId(userId);
			tempRole.setId(roleId);
			temp.setRole(tempRole);
			temp.setUser(tempUser);
			return userInRoleRepository.save(temp);
		}
		throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("Role %d is already assigned to user %d", roleId, userId));
	}


	public void deleteUserInRole(Integer roleId, Integer userId) {
		Optional<UserInRole> result = this.findByRoleIdAndUserId(roleId, userId);
		if(result.isPresent()) {
			userInRoleRepository.delete(result.get());
		}
	}
}
