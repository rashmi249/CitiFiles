package serialstreampack;

import java.util.ArrayList;
import java.util.List;

public class TestMatchStreams {
public static void main(String[] args) {
	//boolean allMatch(cond) - till all elements return true
	//boolean 
	
	List<Employee> list=new ArrayList();
	list.add(new Employee(1001, "john", 34));
	list.add(new Employee(1003, "john", 64));
	list.add(new Employee(1006, "john", 36));
	
	
	boolean res=list.stream().allMatch((Employee e) -> e.getAge()>30);
	System.out.println("All Match -" +res);
	
	//NoneMatch
	

	boolean resNonematch=list.stream().noneMatch((Employee e) -> e.getAge()>30);
	System.out.println("All Match -" +resNonematch);
	
	//AnyMatch
	

		boolean resAnymatch=list.stream().noneMatch((Employee e) -> e.getAge()>30);
		System.out.println("All Match -" +resAnymatch);
}
}
