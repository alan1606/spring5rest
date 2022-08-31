package com.aaguirre.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aaguirre.users.entities.User;
import com.aaguirre.users.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Page<User> getUsers(int page, int size){
		return userRepository.findAll(PageRequest.of(page, size));
	}
	
	public User getUserById(Integer id) {
		 Optional<User> result = userRepository.findById(id);
		 if(result.isPresent()) {
			 return result.get();
		 }
		 throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("The user with id %d doesn't exists", id));
	} 
	
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("The user %s doesn't exists", username)));
	}
	
	public User getUserByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("The user %s doesn't exists", username)));
	}

	public Page<String> getUsernames(int page, int size) {
		return userRepository.findUsernames(PageRequest.of(page, size));
	}
}
