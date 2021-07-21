package com.demo.demo_hibernate_app;

import entities.User;
import service.UserNotFoundException;
import service.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UserNotFoundException
    {
    	 UserService service = new UserService();
   	  
   User entity = new User();
    entity.setEmail("john@test.com");
    entity.setFirstName("johnyyyyyyyyyyyyy");
  
    
    service.createUser(entity);
   
    service.updateUser(entity);
    
    service.loadEntity(1L);
    
    service.criratiaQueryByName();
  //service.findUser(1);
   //service.deleteUser(1L);
    //System.out.println(service.createUser(entity));
    }
}
