package com.aaguirre.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aaguirre.users.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
