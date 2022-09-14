package com.demo;

import java.util.Date;

import com.entities.EmpLocation;
import com.entities.Employee;
import com.entities.EmployeeCustom;
import com.models.CustomEmployeeModel;
import com.models.EmpLocationModel;
import com.models.EmployeeModel;




public class demo {
	public static void main(String[] args) {	
//		EmployeeModel employeeModel = new EmployeeModel();
//		Employee employee = employeeModel.findById(8);
//		employee.setEmployeeId(null);
//		employee.setName("Employee E");
//		employee.setEmail("employeeE@gmail.com");
//		employee.setImage("employeeE.png");
//		employee.setUsername("employeeE");
//		Employee employeeCreate = employeeModel.create(employee);
		//if(employeeCreate != null) {
			EmpLocationModel empLocationModel = new EmpLocationModel();
			EmpLocation empLocation = empLocationModel.findById(9);
			empLocation.setLocationId(2);
			boolean result = empLocationModel.create(empLocation);
			System.out.println(result);
		//}
		
	}
}
