package core;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


//@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class ToDoBusinessWithMockitoAnnotations {

	@Mock
	TodoService toDoservice;
	
	@InjectMocks
	ToDoBusinessImpl service;
	
	
/**@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}**/
	
	
	@Test
	void test1() {
	 //	TodoService service = org.mockito.MockitoAnnotations.Mock.class
		//TodoService service= mock(TodoService.class);
		
		//When-then
		when(toDoservice.retrieveTodos(anyString())).thenReturn(Arrays.asList("Spring MVC", "Spring Boot" ,"Starting with Spring"));
		
		//setUp
		
	//	ToDoBusinessImpl businessImpl=new ToDoBusinessImpl(service);
		
		//Execute
	   List<String> filteredList =	service.retrieveTodosRelatedToSpring(anyString());
	
    	assertNotNull(filteredList);
	}
	
	

}
