package serialstreampack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class TestStreamCode {

	public static void main(String[] args) {
		List<Employee> list=new ArrayList();
		list.add(new Employee(1001, "john", 34));
		list.add(new Employee(1003, "john", 64));
		list.add(new Employee(1006, "john", 36));
		
		Stream<Employee> stream=list.stream();
		//System.out.println("stream "+ stream);
		
		
		// Consumer -> void accept(T)
        Consumer<Employee> consumer = emp -> System.out.println(emp.getId()); 
        
        //peek() is used for debugging 
        Stream<Employee> peekStream = 
                 stream.peek(consumer);
        
        long totalCount = peekStream.count();
        System.out.println("Count of Employees - " + totalCount);
        
        // stream(Employee) -> peekStrean(print Employee) -> count()[long] -> Stream is closed
    
        // If any other operation is performed on closed stream, then IllegalStateException is raised at runtime
        //  long  count1 = peekStream.count();
        // System.out.println("Count 1 = " + count1);
         
         // builder pattern
          long res = list.stream().peek((Employee e) ->  System.out.println(e)).count();
          System.out.println("Count result - " + res);
		
	}

}
