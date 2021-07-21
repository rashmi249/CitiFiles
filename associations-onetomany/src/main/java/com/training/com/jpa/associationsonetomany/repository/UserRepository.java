package com.training.com.jpa.associationsonetomany.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.training.com.jpa.associationsonetomany.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{

	//findbyFirstname
	User findByfirstNameAndEmail(String name, String email);
	
	//to customize queries on return type
//	@Query("SELECT u.email FROM usertest u where u.id= :id")
	//String findByEmailById(@Param("id") Long id);
	
	//based on firstname and Email
	
	public User findbyEmail(String email);
	
	
}
