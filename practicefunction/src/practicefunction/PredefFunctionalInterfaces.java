package practicefunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PredefFunctionalInterfaces {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
		
		//Predicate
		Predicate<Integer> predicate = a -> a%2!=0;

		List<Integer> listodd = list.stream().filter(predicate).collect(Collectors.toList());
		System.out.println(listodd);
		
		
		//Consumer accept(a) Used to print an element, sysout
		Consumer<Integer> consumer = t -> System.out.println(t);
		
		consumer.accept(4);
		
		
		//supplier T get()
		Supplier<String> sup = () -> "Hiiiiiiiiiiiiii";
		
		System.out.println(sup.get());
		sup.get();
		
		//Function
		Function<Integer,Integer> function = a -> a*a;
		
		System.out.println(function.apply(6));
	}

}
