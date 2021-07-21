package core;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class ToDoBusinessImplTestWithMockito {
	
//	!--         <dependency> -->
//	<!-- 	<groupId>org.mockito</groupId> -->
//	<!-- 	<artifactId>mockito-all</artifactId> -->
//	<!-- 	<version>1.10.19</version> -->
//	<!-- 	<scope>test</scope> -->
//	<!-- </dependency> -->

	String userName="admin";
	@Test
	void test() {
	 //	TodoService service = org.mockito.MockitoAnnotations.Mock.class
		TodoService service= mock(TodoService.class);
		
		//When-then
		when(service.retrieveTodos(anyString())).thenReturn(Arrays.asList("Spring MVC", "Spring Boot" ,"Starting with Spring"));
		
		//setUp
		
		ToDoBusinessImpl businessImpl=new ToDoBusinessImpl(service);
		
		//Execute
	   List<String> filteredList =	businessImpl.retrieveTodosRelatedToSpring(userName);
	
    	assertNotNull(filteredList);
	}

	
	//Testcse if returned list contains item with no "Spring" in them,then returned list size is zero

	@Test
	void testNotContainingSpring() {
	 //	TodoService service = org.mockito.MockitoAnnotations.Mock.class
		TodoService service= mock(TodoService.class);
		
		//When-then
		when(service.retrieveTodos(userName)).thenReturn(Arrays.asList("MVC", "Boot" ,"Starting with"));
		
		//setUp
		ToDoBusinessImpl businessImpl=new ToDoBusinessImpl(service);	
	   
		//Execute
	   List<String> filteredList =	businessImpl.retrieveTodosRelatedToSpring("dd");
	
	   //assertion
	 //  assertThat(filteredList, allOf(has));
	   assertThat(filteredList, notNullValue() );
	   assertEquals(0, filteredList.size());
	   
	  
    	
	}
	//VerifyToDoServiceMethodWasCalledOrNot
	@Test
	void VerifyToDoServiceMethodWasCalledOrNot() {
	 //	TodoService service = org.mockito.MockitoAnnotations.Mock.class
		TodoService service= mock(TodoService.class);
		
		//When-then
		when(service.retrieveTodos(userName)).thenReturn(Arrays.asList("MVC", "Boot" ,"Starting with"));
		
		//setUp
		ToDoBusinessImpl businessImpl=new ToDoBusinessImpl(service);	
	   
		//Execute
	   List<String> filteredList =	businessImpl.retrieveTodosRelatedToSpring("dd");
	
	//  verify(service, atLeastOnce()).retrieveTodos(anyString());
	   
	   verify(service, times(1)).retrieveTodos(anyString());
    	
	}
}
