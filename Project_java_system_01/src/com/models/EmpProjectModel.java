package com.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entities.EmpLocation;
import com.entities.EmpProject;
import com.entities.Empdepartment;

public class EmpProjectModel {
	
	// findAll
	public List<EmpProject> findAllByEmployeeId(int employeeId){
		List<EmpProject> empProjects = new ArrayList<EmpProject>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from emp_project where employee_id = ? order by emp_project_id desc");
			preparedStatement.setInt(1, employeeId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				EmpProject empProject = new EmpProject();
				empProject.setId(resultSet.getInt("emp_project_id"));
				empProject.setProjectId(resultSet.getInt("project_id"));
				empProject.setEmployeeId(resultSet.getInt("employee_id"));
				empProject.setDescription(resultSet.getString("description"));	
				empProject.setFromDate(resultSet.getDate("from_date"));
				empProject.setToDate(resultSet.getDate("to_date"));
				empProjects.add(empProject);
			}
		}catch (Exception e) {
			empProjects = null;
		}finally {
			ConnectDB.disconnect();
		}
		return empProjects;
	}
	
	
	
	
	// Find by Id and orderby employee_id get Default
	public EmpProject findById(int employeeId){
		EmpProject empProject = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from emp_project where employee_id = ?");
			preparedStatement.setInt(1,employeeId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				empProject = new EmpProject();
				empProject.setId(resultSet.getInt("emp_project_id"));
				empProject.setEmployeeId(resultSet.getInt("employee_id"));
				empProject.setProjectId(resultSet.getInt("project_id"));				
				empProject.setFromDate(resultSet.getDate("from_date"));
				empProject.setToDate(resultSet.getDate("to_date"));
				empProject.setDescription(resultSet.getString("description"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			empProject = null;
		}finally {
			ConnectDB.disconnect();
		}
		return empProject;
	}
		
	// Update EmpProject
	public boolean update(EmpProject empProject){
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("update emp_project set project_id  = ? ,employee_id  = ? , from_date = ? , to_date = ? , description = ?  where emp_project_id  = ? ");
			preparedStatement.setInt(1, empProject.getProjectId());
			preparedStatement.setInt(2, empProject.getEmployeeId());
			preparedStatement.setDate(3,new java.sql.Date(empProject.getFromDate().getTime()));
			preparedStatement.setDate(4,new java.sql.Date(empProject.getToDate().getTime()));
			preparedStatement.setString(5, empProject.getDescription());
			preparedStatement.setInt(6, empProject.getId());
		result = preparedStatement.executeUpdate() > 0;
		
		}catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	
	//Create Department
	public boolean create(EmpProject empProject){
		boolean result = true;
		empProject.setFromDate(new Date());
		try {
			// update toDate and data
			EmpProject empProject2 = findById(empProject.getEmployeeId());
			if(empProject2 !=null) {
				empProject2.setToDate(new Date());
				empProject2.setDescription("a");
				update(empProject2);
			}
			//create new 
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into emp_project(project_id,employee_id,from_date) values(?,?,?) ");
			preparedStatement.setInt(1, empProject.getProjectId());
			preparedStatement.setInt(2, empProject.getEmployeeId());
			preparedStatement.setDate(3,new java.sql.Date(empProject.getFromDate().getTime()));				
			result = preparedStatement.executeUpdate() > 0;
			if(result) {
				System.out.println("--> Created (empDepartment) success");
			}
		}catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
}
