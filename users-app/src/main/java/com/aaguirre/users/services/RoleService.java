package com.aaguirre.users.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aaguirre.users.entities.Role;
import com.aaguirre.users.models.MySecurityRule;
import com.aaguirre.users.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repository;

	// @RolesAllowed({"ROLE_ADMIN"})
	@MySecurityRule
	public List<Role> getRoles() {
		return repository.findAll();
	}

	public Role createRole(Role role) {
		return repository.save(role);
	}

	public Role updateRole(Integer roleId, Role role) {
		Optional<Role> r = repository.findById(roleId);
		if (r.isPresent()) {

			return repository.save(role);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d doesn't exists", roleId));
	}

	public void deleteRole(Integer roleId) {
		Optional<Role> result = repository.findById(roleId);
		if (result.isPresent()) {
			repository.delete(result.get());
			return;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d doesn't exists", roleId));
	}
}
