package com.training.com.jpa.associationsonetomany.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.com.jpa.associationsonetomany.entities.PhoneNumber;

public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Integer>{

}
