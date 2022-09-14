package com.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entities.Empdepartment;
import com.entities.EmpLocation;

public class EmpDepamentModel {
	
	// findAll by employee Id
	public List<Empdepartment> findAllByEmployeeId(int employeeId){
		List<Empdepartment> empdepartments = new ArrayList<Empdepartment>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from emp_department where employee_id = ? order by emp_department_id desc");
			preparedStatement.setInt(1, employeeId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Empdepartment empdepartment = new Empdepartment();
				empdepartment.setId(resultSet.getInt("emp_department_id"));
				empdepartment.setDepartmentId(resultSet.getInt("department_id"));
				empdepartment.setEmployeeId(resultSet.getInt("employee_id"));
				empdepartment.setDescription(resultSet.getString("description"));	
				empdepartment.setFromDate(resultSet.getDate("from_date"));
				empdepartment.setToDate(resultSet.getDate("to_date"));
				empdepartments.add(empdepartment);
			}
		}catch (Exception e) {
			empdepartments = null;
		}finally {
			ConnectDB.disconnect();
		}
		return empdepartments;
	}
	
	
	
	
	//Create Department
		public boolean create(Empdepartment empDepartment){
			boolean result = true;
			empDepartment.setFromDate(new Date());
			try {
				// update toDate and data
				Empdepartment empDepartment2 = findById(empDepartment.getEmployeeId());
				if(empDepartment2 !=null) {
					empDepartment2.setToDate(new Date());
					empDepartment2.setDescription("a");
					update(empDepartment2);
				}
				//create new 
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("insert into emp_department(department_id,employee_id,from_date) values(?,?,?) ");
				preparedStatement.setInt(1, empDepartment.getDepartmentId());
				preparedStatement.setInt(2, empDepartment.getEmployeeId());
				preparedStatement.setDate(3,new java.sql.Date(empDepartment.getFromDate().getTime()));				
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
		
		
	// Find by EmployeeId and depamentId
		public Empdepartment findByEmpIdAndDepamentId(int employeeId,int departmentId){
			Empdepartment empdepartment = null;
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("select * from emp_department where employee_id = ? and department_id = ? order by employeeId asc");
				preparedStatement.setInt(1,employeeId);
				preparedStatement.setInt(2,departmentId);
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					empdepartment = new Empdepartment();
					empdepartment.setId(resultSet.getInt("emp_department_id"));
					empdepartment.setEmployeeId(resultSet.getInt("employee_id"));
					empdepartment.setDepartmentId(resultSet.getInt("department_id"));				
					empdepartment.setFromDate(resultSet.getDate("from_date"));
					empdepartment.setToDate(resultSet.getDate("to_date"));
					empdepartment.setDescription(resultSet.getString("description"));
				}
			}catch (Exception e) {
				e.printStackTrace();
				empdepartment = null;
			}finally {
				ConnectDB.disconnect();
			}
			return empdepartment;
		}
		
		// Find by Id and orderby employee_id get Default
		public Empdepartment findById(int employeeId){
			Empdepartment empdepartment = null;
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("select * from emp_department where employee_id = ?");
				preparedStatement.setInt(1,employeeId);
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					empdepartment = new Empdepartment();
					empdepartment.setId(resultSet.getInt("emp_department_id"));
					empdepartment.setEmployeeId(resultSet.getInt("employee_id"));
					empdepartment.setDepartmentId(resultSet.getInt("department_id"));				
					empdepartment.setFromDate(resultSet.getDate("from_date"));
					empdepartment.setToDate(resultSet.getDate("to_date"));
					empdepartment.setDescription(resultSet.getString("description"));
				}
			}catch (Exception e) {
				e.printStackTrace();
				empdepartment = null;
			}finally {
				ConnectDB.disconnect();
			}
			return empdepartment;
		}
			
		// Update Department
		public boolean update(Empdepartment empdepartment){
			System.out.println("empdepartment : " + empdepartment.toString());
			boolean result = true;
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("update emp_department set department_Id  = ? ,employee_id  = ? , from_date = ? , to_date = ? , description = ?  where emp_department_id = ? ");
				preparedStatement.setInt(1, empdepartment.getDepartmentId());
				preparedStatement.setInt(2, empdepartment.getEmployeeId());
				preparedStatement.setDate(3,new java.sql.Date(empdepartment.getFromDate().getTime()));
				preparedStatement.setDate(4,new java.sql.Date(empdepartment.getToDate().getTime()));
				preparedStatement.setString(5, empdepartment.getDescription());
				preparedStatement.setInt(6, empdepartment.getId());
			result = preparedStatement.executeUpdate() > 0;
			if(result) {
				System.out.println("--> Update (empDepartment) success");
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
