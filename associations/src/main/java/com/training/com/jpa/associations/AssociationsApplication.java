package com.training.com.jpa.associations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.com.jpa.associations.entities.User;
import com.training.com.jpa.associations.repository.UserRepository;
import com.training.com.jpa.associations.repository.UserRepositoryImpl;

@SpringBootApplication
public class AssociationsApplication implements CommandLineRunner{
	
	@Autowired
	UserRepositoryImpl repository;

	//This will create instance of spring apllication context
	public static void main(String[] args) {
		SpringApplication.run(AssociationsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User entity =new User();
		entity.setId(4L);
        entity.setFirstName("vishal");
        entity.setEmail("vishal@test.com");
        //entity.setCreationDate(LocalDate.of(1997, 10, 24));
        repository.createUser(entity); // Save() -> em.persist()
        repository.delete(1L);
		
	}

}
