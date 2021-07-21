package service;

import java.util.List;

import entities.User;
import repository.UserRepository;

public class UserService {

	//Hibernate API
	
	private UserRepository repository= new UserRepository();
	
	public void  createUser(User user) {
		repository.saveUser(user);
	}
	
	 public User findByUserId(Long id) throws UserNotFoundException {
	        return repository.findByUserId(id);

	    }
	
	public void updateUser(User user) throws UserNotFoundException {
		repository.updateUser(user);
	}

	   public void deleteUser(Long id) throws UserNotFoundException {
	        repository.deleteUser(id);
	    }
	   
	   
	   public void loadEntity(Long id) {
	        repository.loadEntity(1L);
	    }
	   
	   public void fetchLimitedResult(Long id) {
	        repository.fetchLimitedResult();
	    }
	   
	   public void criratiaQueryByName() {
		List<User> list=   repository.criratiaQueryByName();
		
	   }
}
