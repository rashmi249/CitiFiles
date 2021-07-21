package com.training.com.jpa.associationsonetomany;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.com.jpa.associationmanytomany.User1;
import com.training.com.jpa.associationsonetomany.repository.UserManyRepository;

@SpringBootTest
class TestManytoMany {
	
	UserManyRepository repository;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFinder() {
	User1 user = repository.findById(1L).get();
	
	}

}
