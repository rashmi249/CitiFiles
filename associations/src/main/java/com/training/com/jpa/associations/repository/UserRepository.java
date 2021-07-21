package com.training.com.jpa.associations.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.com.jpa.associations.entities.User;

public interface UserRepository extends CrudRepository<User,Long> {

	
}
