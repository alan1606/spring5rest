package com.aaguirre.users.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aaguirre.users.entities.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {

	@Query("select p from Profile p where p.user.id = ?1 and p.id = ?2")
	public Optional<Profile> findByUserIdAndProfileId(Integer userId, Integer profileId);

	@Query("select p from Profile p where p.user.id = ?1")
	public Optional<Profile> findByUserId(Integer userId);
	
}
