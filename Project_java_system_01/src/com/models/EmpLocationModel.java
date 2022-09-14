package com.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entities.EmpLocation;
import com.entities.Employee;
import com.entities.Location;

public class EmpLocationModel {
	// findAll
	public List<EmpLocation> findAllByEmployeeId(int employeeId){
		List<EmpLocation> empLocations = new ArrayList<EmpLocation>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from emp_location where employee_id = ? order by emp_location_id desc");
			preparedStatement.setInt(1, employeeId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				EmpLocation empLocation = new EmpLocation();
				empLocation.setId(resultSet.getInt("emp_location_id"));
				empLocation.setLocationId(resultSet.getInt("location_id"));
				empLocation.setEmployeeId(resultSet.getInt("employee_id"));
				empLocation.setDescription(resultSet.getString("description"));	
				empLocation.setFromDate(resultSet.getDate("from_date"));
				empLocation.setToDate(resultSet.getDate("to_date"));
				empLocations.add(empLocation);
			}
		}catch (Exception e) {
			empLocations = null;
		}finally {
			ConnectDB.disconnect();
		}
		return empLocations;
	}

	
	
	//Create EmpLocation
	public boolean create(EmpLocation empLocation){
		boolean result = true;
		empLocation.setFromDate(new Date());
		System.out.println(empLocation.getEmployeeId());
		try {
			// update toDate and data
			EmpLocation empLocation2 = findById(empLocation.getEmployeeId());
			if(empLocation2 !=null) {
				empLocation2.setToDate(new Date());
				empLocation2.setDescription("a");
				update(empLocation2);
			}
			//create new 
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into emp_location(location_id,employee_id,from_date) values(?,?,?) ");
			preparedStatement.setInt(1, empLocation.getLocationId());
			preparedStatement.setInt(2, empLocation.getEmployeeId());
			preparedStatement.setDate(3,new java.sql.Date(empLocation.getFromDate().getTime()));				
			result = preparedStatement.executeUpdate() > 0;
			if(result) {
				System.out.println("--> Created (empLocation) success");
			}
		}catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	
// Find by EmployeeId and LocationId
	public EmpLocation findByEmpIdAndLocationId(int employeeId,int locationId){
		EmpLocation empLocation = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from emp_location where employee_id = ? and location_id = ? order by employeeId asc");
			preparedStatement.setInt(1,employeeId);
			preparedStatement.setInt(2,locationId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				empLocation = new EmpLocation();
				empLocation.setId(resultSet.getInt("emp_location_id "));
				empLocation.setEmployeeId(resultSet.getInt("employee_id "));
				empLocation.setLocationId(resultSet.getInt("location_id  "));				
				empLocation.setFromDate(resultSet.getDate("from_date"));
				empLocation.setToDate(resultSet.getDate("to_date"));
				empLocation.setDescription(resultSet.getString("description"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			empLocation = null;
		}finally {
			ConnectDB.disconnect();
		}
		return empLocation;
	}
	
	// Find by Id and orderby employee_id get Default
	public EmpLocation findById(int employeeId){
		EmpLocation empLocation = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from emp_location where employee_id = ?  ");
			preparedStatement.setInt(1,employeeId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				empLocation = new EmpLocation();
				empLocation.setId(resultSet.getInt("emp_location_id"));
				empLocation.setEmployeeId(resultSet.getInt("employee_id"));
				empLocation.setLocationId(resultSet.getInt("location_id"));				
				empLocation.setFromDate(resultSet.getDate("from_date"));
				empLocation.setToDate(resultSet.getDate("to_date"));
				empLocation.setDescription(resultSet.getString("description"));
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			empLocation = null;
		}finally {
			ConnectDB.disconnect();
		}
		return empLocation;
	}
		
	// Update EmpLocation
	public boolean update(EmpLocation empLocation){
		System.out.println("empLocation : " + empLocation.toString());
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("update emp_location set location_id  = ? ,employee_id  = ? , from_date = ? , to_date = ? , description = ?  where emp_location_id = ? ");
			preparedStatement.setInt(1, empLocation.getLocationId());
			preparedStatement.setInt(2, empLocation.getEmployeeId());
			preparedStatement.setDate(3,new java.sql.Date(empLocation.getFromDate().getTime()));
			preparedStatement.setDate(4,new java.sql.Date(empLocation.getToDate().getTime()));
			preparedStatement.setString(5, empLocation.getDescription());
			preparedStatement.setInt(6, empLocation.getId());
		result = preparedStatement.executeUpdate() > 0;
		if(result) {
			System.out.println("--> Update (empLocation) success");
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
