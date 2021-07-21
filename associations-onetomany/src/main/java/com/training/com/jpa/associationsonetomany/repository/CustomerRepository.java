package com.training.com.jpa.associationsonetomany.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.training.com.jpa.associationsonetomany.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
//defn the query methos -use JPQL to write custom queries
	List<Customer> findByName(String name);
}
