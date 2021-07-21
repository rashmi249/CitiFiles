package assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Tes {
	
	

	public static void main(String args[]) {
		List<Integer> list =Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
		
		Predicate<Integer> p = a -> a%2!=0;
		
		int summ=list.stream().filter(p).mapToInt(i -> i*i).sum();
		
		Consumer<Integer> c= dd -> System.out.println("The sum iss " + summ);
		c.accept(summ);
		
		
		
		
		
	}
}
