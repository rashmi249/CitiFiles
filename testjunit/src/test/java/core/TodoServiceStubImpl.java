package core;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStubImpl implements TodoService {

	@Override
	public List<String> retrieveTodos(String user) {
		
		return Arrays.asList("Spring MVC", "Spring Boot" ,"Starting with Spring");
	}

	@Override
	public void deleteTodo(String todo) {
		// TODO Auto-generated method stub
		
	}

}
