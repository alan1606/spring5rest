package com.aaguirre.users.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aaguirre.users.entities.Role;
import com.aaguirre.users.models.AuditDetails;
import com.aaguirre.users.models.MySecurityRule;
import com.aaguirre.users.repositories.RoleRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@MySecurityRule
public class RoleService {

	@Autowired
	private RoleRepository repository;

	@Autowired
	private KafkaTemplate<Integer, String> kafkaTemplate;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	// @RolesAllowed({"ROLE_ADMIN"})
	public List<Role> getRoles() {
		return repository.findAll();
	}

	public Role createRole(Role role) {
		Role saved = repository.save(role);
		AuditDetails details = new AuditDetails(SecurityContextHolder.getContext().getAuthentication().getName(), role.getName());
		try {
			kafkaTemplate.send("devs4j-topic", mapper.writeValueAsString(details) );
		} catch (JsonProcessingException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error generation message parsing");
		}
		return saved;
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
