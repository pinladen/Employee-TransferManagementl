package com.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entities.Empdepartment;
import com.entities.EmpLocation;
import com.entities.EmpProject;
import com.entities.Employee;
import com.entities.EmployeeCustom;
import com.entities.Location;

public class CustomEmployeeModel {
	
	public EmployeeCustom findById(int employeeId){
		
		EmployeeCustom employeeCustom = new EmployeeCustom();
		EmployeeModel employeeModel = new EmployeeModel();
		EmpLocationModel empLocationModel = new EmpLocationModel();
		LocationModel locationModel = new LocationModel();
		EmpDepamentModel empDepamentModel = new EmpDepamentModel();
		DepamentModel depamentModel = new DepamentModel();
		EmpProjectModel empProjectModel = new EmpProjectModel();
		ProjectModel projectModel = new ProjectModel();
		
		// set employee
		employeeCustom.setEmployee(employeeModel.findById(employeeId));
		
		// set location 
		EmpLocation empLocation = empLocationModel.findById(employeeId);
		if(empLocation !=null) {
			employeeCustom.setLocation(locationModel.findById(empLocation.getLocationId()));
		}		
		
		// set depament 
		Empdepartment empDepartment = empDepamentModel.findById(employeeId);
		if(empDepartment !=null) {
			employeeCustom.setDepament(depamentModel.findById(empDepartment.getDepartmentId()));
		}
		
		// set project 
		EmpProject empProject = empProjectModel.findById(employeeId);
		if(empProject !=null) {
			employeeCustom.setProject(projectModel.findById(empProject.getProjectId()));
		}
		return employeeCustom;
	}
}
