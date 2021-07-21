package functionalpak;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceService {
	

	//R apply(T)
	public int increment(int x) {
		return x+1;
	}
	
	public static void  testFunctionInterface() {
		Function<Integer,Integer> functIntf =x -> x+1;
		int incval = functIntf.apply(10);
		System.out.println("Incremebt value "+ incval);
		
		
		//Return multiple of 10 for a number
		Function<Integer,Integer> functInf =x -> x*10;
		int mulval = functIntf.apply(10);
		System.out.println("Multiple of  10  "+ incval);
		
		//Return the length of given string
		
		Function<String, Integer> strlen = str -> str.length();
		int st= strlen.apply("Rashmi");
		System.out.println("Length of String" + st);
		
		// Return Square of number
		Function<Integer,Integer> retSq =x -> x*x;
		int square= retSq.apply(3);
		System.out.println("Square of 3 is   " + square);
		
		//Return Addition of number
		
		BiFunction<Integer,Integer, Integer> funAdd = (x,y) -> x+y;
		int addition= funAdd.apply(20, 30);
		System.out.println("Addition is "+ addition);
		
	}
	
	public static void  addTwoNumbers(int x, int y)
	{
		BiFunction<Integer, Integer, Integer> bifuncInf =
				(num1, num2) -> Integer.sum(num1, num2 );
				
			int res =	bifuncInf.apply(x, y);
			System.out.println(res);
	}
	
	//Max of two Numbers
	
	public static void maxOfTwoNumbers(int x, int y) {
		BiFunction<Integer, Integer, Integer> funcmax =
				(n1, n2) -> Integer.max(n1, n2);
				
				int maxval= funcmax.apply(x, y);
				Consumer<Integer> consumer = (num) -> {
					System.out.println("Max val -"+num);
				};
				consumer.accept(maxval);
	}
	

	//get Age of Employee 
	//public static void getAgeofEmployee(Employee e) {
		// check if emp age is greater than 35
//		Predicate<Employee> predInf =(Employee emp) -> emp.getAddress()>35;		
	//	System.out.println(predInf.test(e));
		
		//Consumer to print emp name
		//void accept(T)
		
	//	Consumer<Employee> cons = e1 -> System.out.println(e1.getName());
	//	if(predInf.test(e)) {
	//		cons.accept(e);
	//	}
		
	
	//}
	
	//predicate for getAgeofEmployee
	//public static void filter(List<Employee> list , Predicate<Employee> predicate1, Consumer consumer1) {
		
	}
	
	/// capture null pointer exception
	//public void displayEmployeeDetaild
//}
