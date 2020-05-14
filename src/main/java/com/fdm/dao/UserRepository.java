package com.fdm.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fdm.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByUsername(String username);
	long countByUsername(String username);
	long countByEmail(String email);
	
	
	@Query("select u from User u where u.username = :name")
	List<User> customFindByUsername(@Param(value = "name") String name);	
	
}