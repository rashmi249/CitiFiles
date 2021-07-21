package com.training.com.jpa.associationsonetomany;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.com.jpa.associationsonetomany.entities.Customer;
import com.training.com.jpa.associationsonetomany.entities.PhoneNumber;
import com.training.com.jpa.associationsonetomany.repository.CustomerRepository;

@SpringBootTest
class TestOnetoManyRelationship {

	@Autowired
	CustomerRepository repository;
	
	@Test
	public void createCustomer() {
		Customer cust=new Customer();
		
		cust.setId(20);
		cust.setName("Meena");
		
		PhoneNumber ph= new PhoneNumber();
		ph.setId(1);
		ph.setNumber("14353636");
		ph.setType("Landline");
		ph.setCustomer(cust);
		
		PhoneNumber ph1= new PhoneNumber();
		ph1.setId(2);
		ph1.setNumber("67890900");
		ph1.setType("Mobile");
		ph1.setCustomer(cust);
		
		//creating hashset object
		HashSet<PhoneNumber> numbers= new HashSet<PhoneNumber>();
		numbers.add(ph);
		numbers.add(ph1);
		cust.setNumbers(numbers);
		repository.save(cust); // because of cascade the phone number is inserted
		
	}
	
	@Test
	//@Transactional
	public void testFindCustomer() {
Customer cust=repository.findById(10).get();
assertNotNull(cust);

assertEquals("john", cust.getName());
System.out.println("Cust Details " + cust.getName());

System.out.println("Cust Details " + cust.getNumbers());

		
	}

	@Test
	public void tsetUpdateCustomer() {
Customer cust= repository.findById(10).get();
//update the type for all phone numbers
Set<PhoneNumber> set=cust.getNumbers();
set.forEach(p -> p.setType("Mobile"));
repository.save(cust);
//Optional<PhoneNumber> num=set.stream().findFirst();

	}
	
	
	@Test
	public void tsetDeleteCustomer() {

repository.deleteById(10);
//Optional<PhoneNumber> num=set.stream().findFirst();

	}
	
	@Test
	public void testCustomQueryForname() {
		List<Customer> list = repository.findByName("john");
		assertEquals(1, list.size());
	}
	
	
	public void testFirstNameLastNameJPQLQuery() {
	//	List<>
	}
}
