package functionalpak;

import java.util.Arrays;

public class TestEmployeeService {

	public static void main(String[] args) {
		EmployeeService service = new EmployeeService();
		
		service.sortEmployeeList(Arrays.asList("jill","Paul","Merry","Diya"));

		
		service.greetEmployee("Tina");
		
		service.empId=12345;
		System.out.println(service.getEmployeeId());
	}
	

}
