package assignment;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;



public class FunctionalInterfaceAssignment {
	
	
	/*
	 * Predicate - if(boolean){...} - boolean test(T)
	 * 
	 * Consumer - Open the database/file - printing on console - void accept(T)
	 * 
	 * Function - transform - Accept string value, return its length
	 * 
	 * - R apply(T)
	 * 
	 * Supplier - Return an object or value - constructor method - getters method
	 * 
	 * - T get()
	 */
	
//	1.	Use Predicate functional interface:
//		a.	To check if the length of given string is > 5 characters.
//	Consumer<Employee> cons = e1 -> System.out.println(e1.getName());
//	if(predInf.test(e)) {
//		cons.accept(e);
//	}
//	
	public static void calLength(String s) {
		Predicate<String> pred= (str) -> str.length()>5;
		Consumer<String> c = (s3) -> System.out.println(s);
		if(pred.test(s)) {
			c.accept(s);
		}
	}
	
	
	
//		b.	To check is the given string is not null and empty.
	public static void checkStringIsEmptyorNUll (String str2) {
		Predicate<String> pred= (myStr1) -> (myStr1 == null || myStr1.isEmpty());
		Consumer<String> c = (str3) -> System.out.println("Given String is empty");
		if(pred.test(str2)) {
			c.accept(str2);
		}
	}
	
//		c.	To check if passed date is less than the current date.
	
	
//		d.	Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9) -> print numbers > 5 from the list.
	
	public static void printNumberGreaterThan5(List<Integer> list) {
		Predicate<Integer> pred= (num) ->num>5;
		Function<List<Integer>, List<Integer>> lst = (list1) -> {
			for(int i=0;i<list1.size();i++) {
				if(pred.test(list1.get(i))) {
				list.add(list1.get(i));
			}
		}
			return list;
		};
		
		/*
		 * for(int i=0;i<list1.size();i++) { if(pred.test(list1.get(i))) {
		 * list.add(list1.get(i)); }
		 */
	
	}
	
//		e.	Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9) -> print numbers > 5 & number < 8 from the list.
	
	
	
//		f.	Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB") -> print string whose length  > 3 & strts with character A.


	public static void main(String[] args) {
		

	}

}
