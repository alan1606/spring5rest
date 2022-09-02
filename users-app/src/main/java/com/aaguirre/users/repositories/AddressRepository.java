package com.aaguirre.users.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aaguirre.users.entities.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

	@Query("select a from Address a where a.profile.id = ?2 and a.profile.user.id = ?1")
	public List<Address> findByUserIdAndProfileId(Integer userUd, Integer profileId);
	
}
