package functionalpak;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeService {
	
	public int  empId;
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void sortEmployeeList(List<String> employeelist) {
		Comparator<String> comparenames = (String o1, String o2) -> {
			return o1.compareTo(o2);
		};
		
		Collections.sort(employeelist, comparenames);
		System.out.println(employeelist);
	}
	
	//Method which will greet the employee = welcome - <name>"
	
	public String greetEmployee(String empName) {
	//	return "Welcome"+empName;
		
		//lambda Expression
		
		
	//	employeName="jill";
		
		Message messageInterface = () -> {
			return "Welcome"+empName;
		};
		
		
		return messageInterface.greet();
		
		
	}
	
	public String getEmployeeId() {
		//return "Emp" + this.empId;
		
		Message msgInterface=() -> {
			return "Emp"+ this.empId;
		};
		
		return msgInterface.greet();
	}


}
