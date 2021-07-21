package com.training.com.jpa.associationsonetomany;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.com.jpa.associationsonetomany.entities.User;
import com.training.com.jpa.associationsonetomany.repository.UserRepository;

@SpringBootTest
class TestUserCustomQueries {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Autowired
	UserRepository repository;

	@Test
	void test() {
	User u=new User();
	u.setFirstName("Rashmi");
	u.setEmail("rashmi@gmail.com");
	
	User u1=new User();
	u1.setFirstName("Mosmi");
	u1.setEmail("mosmi@gmail.com");
	
	repository.save(u);
	repository.save(u1);
	}
	
	public void testNamedQuery() {
	//	List<User> list =repository.f
	}

}
