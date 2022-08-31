package com.aaguirre.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aaguirre.users.entities.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}
