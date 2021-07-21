package methodreferences;

import java.util.function.BiFunction;
import java.util.function.Function;

public class TestMethodReferences {

	
	public static void addTwoNumbers(int num1, int num2)
	{
		BiFunction<Integer, Integer, Integer> bifunction = 
				(a,b) -> Integer.sum(a, b);
				
				
				int res =bifunction.apply(num1, num2);
				System.out.println(res);
	}
	
	
	
	public static void addTwoNumbersWithMethodReference(int num1, int num2)
	{
		BiFunction<Integer, Integer, Integer> bifunction = 
			Integer :: max;
			
		int res =bifunction.apply(num1, num2);
				System.out.println(res);
	}
	
	public static void lengthOfString(String name)
	{
		Function<String, Integer> functionInf = 
		(str) -> str.length();
			
		int length = functionInf.apply(name);
				System.out.println(length);
	}
	
	public static void methodReflengthOfString(String name)
	{
		//method references on types
		Function<String, Integer> functionInf =   String :: length;
	//	(str) -> str.length();
		
			
		int length = functionInf.apply(name);
				System.out.println(length);
	}
	
	public static void getPersonname(Person person) {		
		//lambda expression
		Function<Person, String> functionInf = 
		(Person p) -> p.getName(); 
		//(str) -> str.length();
		
		String res = functionInf.apply(person);
		
		System.out.println("Person name -" + res );
	}
	
	public static void methodrefgetPersonname(Person person) {		
		//lambda expression
		Function<Person, String> functionInf = 
		//(Person p) -> p.getName(); 
		//(str) -> str.length();
			//	Function<String, Integer> functionInf =   String :: length;
				Person :: getName;
				
		
		String res = functionInf.apply(person);
		
		System.out.println("Person name -" + res );
	}
	
	public static void getPersonIdGreaterThan200(Person person) {		
		//lambda expression
		Function<Person, String> functionInf = 
		(Person p) -> p.getName(); 
		//(str) -> str.length();
		
		String res = functionInf.apply(person);
		
		System.out.println("Person name -" + res );
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
addTwoNumbers(10, 20);

addTwoNumbersWithMethodReference(70, 80);

methodReflengthOfString("Rashmi");

getPersonname(new Person(100,"john"));
	}

}
