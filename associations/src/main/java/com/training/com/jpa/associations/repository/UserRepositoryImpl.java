package com.training.com.jpa.associations.repository;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.com.jpa.associations.entities.User;

@Repository
public class UserRepositoryImpl  {

	@Autowired
	EntityManager em;

//	@Override
	@Transactional
	public void save(User user) {

	
		  User entity =new User(); entity.setFirstName("kkkriya");
		  entity.setEmail("kkkriya@test.com");
		  entity.setCreationDate(LocalDate.of(1997, 10, 24));
		 
		// transaction started
		em.persist(entity);
		em.flush();
	}
	
	@Transactional
    public void createUser(User user)
    {
        save(user);
        System.out.println("Recored added");
    }
    
    
    @Transactional
    public void delete(Long id) {
        User user = findById(id);
        if(user != null) {
            // session.delete()
            em.remove(user);
        }
        
    }
    
    @Transactional
    public User findById(Long id) {
        System.out.println("Inside repository..");
        // equivalent to session.get()
        User user  = em.find(User.class, id);
        
        return user;
    }



}
