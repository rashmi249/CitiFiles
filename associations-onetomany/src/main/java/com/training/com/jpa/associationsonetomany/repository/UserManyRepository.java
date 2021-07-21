package com.training.com.jpa.associationsonetomany.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.com.jpa.associationmanytomany.User1;

public interface UserManyRepository extends CrudRepository<User1, Long> {

}
