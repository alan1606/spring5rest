package com.aaguirre.users.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aaguirre.users.entities.Profile;
import com.aaguirre.users.entities.User;
import com.aaguirre.users.repositories.ProfileRepository;
import com.aaguirre.users.repositories.UserRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Profile create(Profile profile, Integer userId) {
		Optional<User> result = userRepository.findById(userId);
		if(result.isPresent()) {
			Optional<Profile> profileDb = this.findByUserId(userId);
			if(profileDb.isEmpty()) {
				profile.setUser(result.get());
				return profileRepository.save(profile);
			}
			throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("User %d can only have one profile", userId));
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %d doesn't exists", userId));
	}
	
	public Profile findByUserIdAndProfileId(Integer userId, Integer profileId){
		return profileRepository.findByUserIdAndProfileId(userId, profileId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Profile %d not found for user %d ", profileId, userId)));
	}
	
	
	private Optional<Profile> findByUserId(Integer userId) {
		return profileRepository.findByUserId(userId);
	}
}
