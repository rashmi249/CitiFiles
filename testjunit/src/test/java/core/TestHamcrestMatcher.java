package core;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.CoreMatchers.startsWithIgnoringCase;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.core.AllOf;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestHamcrestMatcher {

	@Test
  public void testValuesWithMatchers() {
		assertThat("hello", is(equalTo("hello")));
		assertThat("hello world", is(containsStringIgnoringCase("Hello")));
	}

	@Test
	public void testCollections() {
		List<String> list =Arrays.asList("john","jill","peter");
		
		
		//to check if list size=2
		
		assertThat(list.size(), is(3));
		
		//tocheck if list contains "jill" & "peter"
	//	assertThat(list, hasItems("peter","de","jill"));
		
		//use of any or all -logical matchers
	assertThat(list, hasItems(allOf(allOf(startsWith("j")),containsString("k"))));
	//	assertThat(list, any)
	}
	

	@Test
  public void test_passed_string_isnot_null_value() {
		List<String> list =Arrays.asList("john","jill","peter");
	//	assertThat("hello", is(notNullValue()));
		
		//list not contains null values
		assertThat(list, is(notNullValue()));
	}
	
	@Test
	  public void test_every_item_inlist_startwith_J() {
		//	List<String> list =Arrays.asList("john","jill","peter");
		
		List<String> list =Arrays.asList("john","jill","peter",null);
		assertThat(list, everyItem(startsWithIgnoringCase("j")));
		
		
		
		}
		
	
}
