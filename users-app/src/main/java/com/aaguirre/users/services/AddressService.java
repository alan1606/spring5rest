package com.aaguirre.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aaguirre.users.entities.Address;
import com.aaguirre.users.entities.Profile;
import com.aaguirre.users.repositories.AddressRepository;
import com.aaguirre.users.repositories.ProfileRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ProfileRepository profileRepository;

	public List<Address> findByUserIdAndProfileId(Integer userId, Integer profileId) {
		return addressRepository.findByUserIdAndProfileId(userId, profileId);
	}

	public Address create(Integer userId, Integer profileId, Address address) {
		Optional<Profile> result = profileRepository.findByUserIdAndProfileId(userId, profileId);
		if(result.isPresent()) {
			address.setProfile(result.get());
			return addressRepository.save(address);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Profile %d not found for user %d ", profileId, userId));
	}
}
