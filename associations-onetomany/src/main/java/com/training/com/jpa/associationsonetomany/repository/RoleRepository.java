package com.training.com.jpa.associationsonetomany.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.com.jpa.associationmanytomany.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

}
