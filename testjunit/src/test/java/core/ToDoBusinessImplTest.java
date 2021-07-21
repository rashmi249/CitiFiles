package core;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ToDoBusinessImplTest {
	ToDoBusinessImpl businessImpl;
	
	@BeforeEach
	public void setUp() {
		//SetUp -create object of ToDoBusinessImpl
		
		TodoService service = new TodoServiceStubImpl();
		
		businessImpl =new ToDoBusinessImpl(service);
	}

	@Test
	void testRetrieveTodosRelatedToSpring() {
		String userName="admin";
		//execute
		
	List<String> filteredList=	businessImpl.retrieveTodosRelatedToSpring(userName);
		//verify
		
	
	//size is not zero
	
	assertThat(filteredList.size(), is(equalTo(3)));
	
	
	
	}
	
	
	
	@Test
	public void testReturnedListContainsValueSpringInIT() {
		String userName="admin";
		//execute
		
	List<String> filteredList=	businessImpl.retrieveTodosRelatedToSpring(userName);
		//verify
		
	
	//size is not zero
	
	assertThat(filteredList, hasItem(startsWith("Spring")));
	
	
	
	}
	
	//list returned is n ot null
	
	@Test
	public void testReturnedListIsTypeOfList() {
		String userName="admin";	
	List<String> filteredList=	businessImpl.retrieveTodosRelatedToSpring(userName);	
	// verify
	assertThat(filteredList, instanceOf(ArrayList.class));	
	}
	
	//combine returned values are of type list and the size of list is not zero
	//assertThat,logical matcher
	
	@Test
	void testRetrieveTodosRelatedToSpringChekeForListSizeNotZero() {
	String user = "Omkar";
	List<String> listReturn = businessImpl.retrieveTodosRelatedToSpring(user);
	//assertThat(listReturn, not(hasSize(0)));
	}
	
	@Test
	void testSpringChekeForListSizeNotZeroCombineWithSizeofListZero() {
	String user = "admin";
	List<String> filteredList = businessImpl.retrieveTodosRelatedToSpring(user);
	//assertThat(listReturn, not(hasSize(0)));
	
//	assertThat(filteredList, hasItems(notNullValue()),instanceOf(ArrayList.class));
	//assertThat(filteredList, allOf(not(hasSize(0)),instanceOf(ArrayList.class));
	}
	
	@Test
	void testNotNull() {
		String userName="admin";
		//execute
		
	List<String> filteredList=	businessImpl.retrieveTodosRelatedToSpring(userName);
		//verify
		
	
	//size is not zero
	
	assertNotNull(filteredList);
	
	
	
	}
	

}
