package core;


import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GreetingImplTest {
	
	
	Greeting object;
	
	@BeforeEach
	public void setUp() {
	  object=new GreetingImpl();
		System.out.println("Before test case executes");
	}
	
	@AfterEach
	public void tearDown() {
		System.out.println("After test case executes");
		object=null;
	}
	
	
	@BeforeAll
	public static void setUpResources() {
		System.out.println("Will execute only once");
	}

	@Disabled
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	
//	@Tag("PROD") run in prod environment
	
	@Test
	@Tag("Dev")
	public void should_ReturnValue_StartingWithHello_And_PassedString() {
		//setup -create an object
	//	Greeting object=new GreetingImpl();
		String name="Citiustech";
		
		//Execute -code under test
		String result=object.greet(name);
		
		
		//Verify -assertion
		assertEquals("Hello Citiustech", result);
		
		assertNotEquals("Hello World Citiustech", result);
		System.out.println("should_ReturnValue_StartingWithHello_And_PassedString");
	}
	
	@Test
	public void should_NotReturnValue_If_AnyOtherStringConstant_IS_Expected() {
		
		System.out.println("should_NotReturnValue_If_AnyOtherStringConstant_IS_Expected");
		//setup -create an object
	//	Greeting object=new GreetingImpl();
		String name="Citiustech";
		
		//Execute -code under test
		String result=object.greet(name);
		
		
		//Verify -assertion
		assertEquals("Hello  world Citiustech", result);

	}
	
	@Test()
	public void should_Return_Exception_WhenPassedString_isNullValue() {
		System.out.println("should_Return_Exception_WhenPassedString_isNullValue");
		//setup -create an object
	//	Greeting object=new GreetingImpl();
		String name=null;
		
		//Execute -code under test
	//	String result=object.greet(name);
		
		
		//Verify -assertion
	
	assertThrows(IllegalArgumentException.class, ()-> object.greet(name));
	}
	
	@Test()
	public void should_Return_Exception_WhenPassedString_isEmptyString() {
		
		System.out.println("should_Return_Exception_WhenPassedString_isEmptyString");
		//setup -create an object
	//	Greeting object=new GreetingImpl();
		String name="";
		
		//Execute -code under test
	//	String result=object.greet(name);
		
		
		//Verify -assertion
	
	assertThrows(IllegalArgumentException.class, ()-> object.greet(name));
	}

	
	//Test that returned result contains hello string inside it
	
	
	@Test
	public void should_ReturnValue_ContainsHelloString() {
		System.out.println("should_ReturnValue_ContainsHelloString");
		//setup -create an object
	//	Greeting object=new GreetingImpl();
		String name="Citiustech";
		
		//Execute -code under test
		String result=object.greet(name);
		
		assertTrue(object.greet(name).contains("Hello"));
		
	}
	

	
	//Hamcrest library
	@Test
	public void should_ReturnValue_ContainsHello_In_String() {
		System.out.println("should_ReturnValue_ContainsHello_In_String");
		//setup -create an object
	//	Greeting object=new GreetingImpl();
		String name="Citiustech";
		
		//Execute -code under test
		String result=object.greet(name);
		
		
		//assertThat(actual,expected)
		assertThat(result, containsString("Hello"));
	
	
	}
	
	@Test
	public void should_create_An_Object_of_GreetingImpl_Class() {
		System.out.println("should_create_An_Object_of_GreetingImpl_Class");
		//setup -create an object
		//Greeting object=new GreetingImpl();
	
		//verify
		assertNotNull(object);

	
	}
}
