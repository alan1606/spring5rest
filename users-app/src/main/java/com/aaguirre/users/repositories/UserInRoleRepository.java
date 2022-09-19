package com.aaguirre.users.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aaguirre.users.entities.User;
import com.aaguirre.users.entities.UserInRole;

@Repository
public interface UserInRoleRepository extends CrudRepository<UserInRole, Integer>{

	@Query("select distinct(uir.user) from UserInRole uir where uir.role.id = ?1")
	public List<User> findByRoleId(Integer roleId);
	
	@Query("select uir from UserInRole uir where uir.role.id = ?1 and uir.user.id = ?2")
	public Optional<UserInRole> findByRoleIdAndUserId(Integer roleId, Integer userId);

	@Query("select u from UserInRole u where u.user = ?1")
	public List<UserInRole> findByUser(User user);
	
	
}
