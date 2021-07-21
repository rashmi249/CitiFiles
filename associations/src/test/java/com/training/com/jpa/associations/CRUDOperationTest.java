package com.training.com.jpa.associations;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.Transient;
import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.com.jpa.associations.entities.User;

@SpringBootTest
class CRUDOperationTest {
	
	@Autowired
	EntityManager em; //same as session object

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Transactional
	void testCreateUser() {
		User entity =new User();
		entity.setFirstName("priya");
		entity.setEmail("priya@test.com");
		//entity.setCreationDate(LocalDate.of(1997, 10, 24));
	//transaction started
	em.persist(entity);
	em.flush();
	//transaction committed
	

	
	}

}
