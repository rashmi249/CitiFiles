package com.training.com.jpa.associationsonetomany;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import com.training.com.jpa.associationsonetomany.entities.Customer;
import com.training.com.jpa.associationsonetomany.repository.CustomerRepository;

@SpringBootTest
//@Tag
class CustomerRepositoryTest {
	
	@Autowired
	CustomerRepository repository;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		Customer entity =new Customer();
		entity.setId(10);
		entity.setName("Rashmi");
		
		repository.save(entity);
	}
	
	
	@Test
	public void testFinder() {
		Customer customer =repository.findById(10).get();
		assertNotNull(customer);
		assertEquals("Rashmi", customer.getName());
	}
	
	@Test
	public void updateCustomer() {
		Customer entity =new Customer();
       entity.setId(10);
		entity.setName("Neha");
		repository.save(entity);
		//assertEquals("Rashmi", customer.getName());
	}
	
	@Test
	public void deleteCustomer() {
	//	Customer customer =repository.findById(10).get();
	//	repository.deleteById(10);
		//Users user = findById(id);
       // if(user != null) {
            // session.delete()
      //      em.remove(user);
 //       }
	//assertEquals(null, customer);
	}

}
