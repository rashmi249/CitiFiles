package codepractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Java8Practice {

	public static void main(String[] args) {
    List<Employee> emplist= new ArrayList<Employee>();
    //Employee(int empId, String empName, int deptId, String status, int salary)
    emplist.add(new Employee(101,"siva",101,"active",3000));
    emplist.add(new Employee(102,"diva",101,"active",8000));
    emplist.add(new Employee(103,"miva",102,"inactive",5000));
    emplist.add(new Employee(104,"tiva",102,"inactive",8000));
    emplist.add(new Employee(105,"riva",103,"active",6000));
    emplist.add(new Employee(106,"kiva",103,"inactive",4000));
    emplist.add(new Employee(107,"diva",104,"active",4000));
    
    //to print emp details on the basis of department
    Map<Integer, List<Employee>>   m = emplist.stream().collect(Collectors.groupingBy(Employee:: getDeptId));
//  m.entrySet().forEach(entry -> System.out.println(entry.getKey()+" "+entry.getValue()));
    for(Entry<Integer, List<Employee>> entry: m.entrySet()) {
    	System.out.println(entry.getKey()+" "+entry.getValue());
    }
    
    //Write a program to print employees count working in each department
    
 Map<Integer,Long> empcount=  emplist.stream().collect(Collectors.groupingBy(Employee:: getDeptId, Collectors.counting()));
 empcount.entrySet().forEach(entry -> System.out.println(entry.getKey()+ "----" +entry.getValue()));
    
 
 //Write a program to print active and inactive employees in the given collection
 Map<String,List<Employee>> status = emplist.stream().collect(Collectors.groupingBy(Employee::getStatus));
 status.entrySet().forEach(entry ->System.out.println(entry.getKey() + "------"+ entry.getValue()));
 
 //Write a program to print Max/Min employee salary from the given collection
 OptionalInt salary = emplist.stream().mapToInt(Employee :: getSalary).min();
 
 if(salary.isPresent()) {
	 System.out.println("Min Salary is...."+ salary.getAsInt());
 }
 
 //Write a program to print the max salary of an employee from each department
// emplist.stream().collect(groupingBy(e -> e. ,collectingAn));
 
 //name, age orders
 
 List<Employee> empplist = emplist.stream().sorted(Comparator.comparing(Employee::getEmpName).thenComparing(Employee::getSalary, Comparator.reverseOrder()))
 .collect(Collectors.toList());
 System.out.println("NAMe Salary Sorting "+ empplist);
 
 
 //second highest salary
 Optional<Integer> x=emplist.stream().map(e -> e.getSalary()).sorted(Comparator.reverseOrder())
 .skip(2).findFirst();
 if(x.isPresent()) {
	 System.out.println("Second Highest Salary is...."+ x.get());
 }
 
	}

}
