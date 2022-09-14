package com.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.entities.EmpLocation;
import com.entities.EmpProject;
import com.entities.Empdepartment;
import com.entities.Employee;
import com.entities.EmployeeCustom;


public class EmployeeModel {
	// findAll
	public List<Employee> findAll(){
		List<Employee> employees = new ArrayList<Employee>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from employee");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(resultSet.getInt("employee_id"));
				employee.setName(resultSet.getString("name"));
				employee.setDob(resultSet.getDate("dob"));
				employee.setPhone(resultSet.getString("phone"));
				employee.setEmail(resultSet.getString("email"));
				employee.setGender(resultSet.getString("gender"));
				employee.setImage(resultSet.getBytes("image"));
				employee.setCreatedAt(resultSet.getDate("created_at"));
				employee.setUsername(resultSet.getString("username"));
				employee.setRoleId(resultSet.getInt("role_id"));
				employee.setTitleId(resultSet.getInt("title_id"));
				employee.setStatus(resultSet.getBoolean("status"));
				employees.add(employee);
			}
			
		}catch (Exception e) {
			employees = null;
		}finally {
			ConnectDB.disconnect();
		}
		return employees;
	}
	
	// findAll (List<Employee>)
		public List<Employee> searchByName(String keyword){
			List<Employee> employees = new ArrayList<Employee>();
			try {
				PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from employee where name like ?");
				preparedStatement.setString(1,"%" + keyword + "%");
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					Employee employee = new Employee();
					employee.setEmployeeId(resultSet.getInt("employee_id"));
					employee.setName(resultSet.getString("name"));
					employee.setDob(resultSet.getDate("dob"));
					employee.setPhone(resultSet.getString("phone"));
					employee.setEmail(resultSet.getString("email"));
					employee.setGender(resultSet.getString("gender"));
					employee.setImage(resultSet.getBytes("image"));
					employee.setCreatedAt(resultSet.getDate("created_at"));
					employee.setUsername(resultSet.getString("username"));
					employee.setRoleId(resultSet.getInt("role_id"));
					employee.setTitleId(resultSet.getInt("title_id"));
					employee.setStatus(resultSet.getBoolean("status"));
					employees.add(employee);
				}
				
			}catch (Exception e) {
				employees = null;
			}finally {
				ConnectDB.disconnect();
			}
			return employees;
		}
	
	
	// Find by Id
		public Employee findById(int id){
			Employee employee = null;
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("select * from employee where employee_id = ?");
				preparedStatement.setInt(1,id);
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					employee = new Employee();
					employee.setEmployeeId(resultSet.getInt("employee_id"));
					employee.setName(resultSet.getString("name"));
					employee.setDob(resultSet.getDate("dob"));
					employee.setPhone(resultSet.getString("phone"));
					employee.setEmail(resultSet.getString("email"));
					employee.setGender(resultSet.getString("gender"));
					employee.setImage(resultSet.getBytes("image"));
					employee.setTitleId(resultSet.getInt("title_id"));
					employee.setCreatedAt(resultSet.getDate("created_at"));
					employee.setUsername(resultSet.getString("username"));
					employee.setPassword(resultSet.getString("password"));
					employee.setRoleId(resultSet.getInt("role_id"));
					employee.setStatus(resultSet.getBoolean("status"));	
				}
			}catch (Exception e) {
				e.printStackTrace();
				employee = null;
			}finally {
				ConnectDB.disconnect();
			}
			return employee;
		}
		
		
		 //Create employee
		public Employee create(Employee employee){
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("insert into employee(name,dob,phone,email,gender,image,title_id,created_at,username,password,role_id,status) values(?,?,?,?,?,?,?,?,?,?,?,?) ",Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setDate(2,new java.sql.Date(employee.getDob().getTime()));
			preparedStatement.setString(3, employee.getPhone());
			preparedStatement.setString(4, employee.getEmail());
			preparedStatement.setString(5, employee.getGender());
			preparedStatement.setBytes(6, employee.getImage());
			preparedStatement.setInt(7, employee.getTitleId());
			preparedStatement.setDate(8,new java.sql.Date(employee.getCreatedAt().getTime()));
			preparedStatement.setString(9, employee.getUsername());
			preparedStatement.setString(10, employee.getPassword());
			preparedStatement.setInt(11, employee.getRoleId());
			preparedStatement.setBoolean(12, employee.isStatus());
			int affectedRows = preparedStatement.executeUpdate() ;
	        if (affectedRows == 0) {
	            throw new SQLException("Creating employee failed, no rows affected.");
	        }
	        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                employee.setEmployeeId(generatedKeys.getInt(1));
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }
			}catch (Exception e) {
				e.printStackTrace();
				employee = null;
			}finally {
				ConnectDB.disconnect();
			}
			return employee;
		}
		
		//Create employee 2
			public boolean create2(Employee employee , int locationId , int depamentId , int projectId){
				if(create(employee) != null) {
					if(locationId >0) {
						EmpLocationModel empLocationModel = new EmpLocationModel();
						empLocationModel.create(new EmpLocation(null,employee.getEmployeeId(),locationId,new Date(),null,null));
					}
					if(depamentId >0) {
						EmpDepamentModel empDepamentModel  = new EmpDepamentModel();
						empDepamentModel.create(new Empdepartment(null ,employee.getEmployeeId(),depamentId,new Date(),null,null));
					}
					if(projectId >0) {
						EmpProjectModel empProjectModel = new EmpProjectModel();
						empProjectModel.create(new EmpProject(null,employee.getEmployeeId(),projectId,new Date(),null,null));
					}
					return true;
				}
				
				return false;
			}
		
		
		// Update employee
		public boolean update(Employee employee){
			boolean result = true;
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("update employee set name = ?  , dob = ? , phone = ? , email = ?, gender  = ? , image = ?, title_id = ? , created_at = ? , username = ?, password = ? , role_id = ? , status = ? where employee_id = ? ");
				preparedStatement.setString(1, employee.getName());
				preparedStatement.setDate(2,new java.sql.Date(employee.getDob().getTime()));
				preparedStatement.setString(3, employee.getPhone());
				preparedStatement.setString(4, employee.getEmail());
				preparedStatement.setString(5, employee.getGender());
				preparedStatement.setBytes(6, employee.getImage());
				preparedStatement.setInt(7, employee.getTitleId());
				preparedStatement.setDate(8,new java.sql.Date(employee.getCreatedAt().getTime()));
				preparedStatement.setString(9, employee.getUsername());
				preparedStatement.setString(10, employee.getPassword());
				preparedStatement.setInt(11, employee.getRoleId());
				preparedStatement.setBoolean(12, employee.isStatus());
				preparedStatement.setInt(13, employee.getEmployeeId());
			result = preparedStatement.executeUpdate() > 0;
			
			}catch (Exception e) {
				e.printStackTrace();
				result = false;
			}finally {
				ConnectDB.disconnect();
			}
			return result;
		}
		
		// delete employeee
		public boolean delete(int employeeId){
			boolean result = true;
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("delete from employee where id = ? ");
				preparedStatement.setInt(1, employeeId);
			result = preparedStatement.executeUpdate() > 0;
			
			}catch (Exception e) {
				e.printStackTrace();
				result = false;
			}finally {
				ConnectDB.disconnect();
			}
			return result;
		}
		
		
		
	public static Employee checkLogin(String username) {
		Employee employee = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from employee where username = ?");
			preparedStatement.setString(1,username);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				employee = new Employee();
				employee.setEmployeeId(resultSet.getInt("employee_id"));
				employee.setName(resultSet.getString("name"));
				employee.setDob(resultSet.getDate("dob"));
				employee.setPhone(resultSet.getString("phone"));
				employee.setEmail(resultSet.getString("email"));
				employee.setGender(resultSet.getString("gender"));
				employee.setImage(resultSet.getBytes("image"));
				employee.setTitleId(resultSet.getInt("title_id"));
				employee.setCreatedAt(resultSet.getDate("created_at"));
				employee.setUsername(resultSet.getString("username"));
				employee.setPassword(resultSet.getString("password"));
				employee.setRoleId(resultSet.getInt("role_id"));
				employee.setStatus(resultSet.getBoolean("status"));	
			}
		} catch (Exception e) {
			e.printStackTrace();
			employee = null;
		} finally {
			if (ConnectDB.connection() != null)
				try {
					ConnectDB.connection().close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return employee;
	}		
	
//	// Search status
//	public List<book> searchByStatus(boolean status){
//		List<book> products = new ArrayList<Product>();
//		try {
//			PreparedStatement preparedStatement = ConnectDB.connection()
//					.prepareStatement("select * from product where status = ?");
//			preparedStatement.setBoolean(1,status);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			while(resultSet.next()) {
//				Product product = new Product();
//				product.setId(resultSet.getInt("id"));
//				product.setName(resultSet.getString("name"));
//				product.setPrice(resultSet.getDouble("price"));
//				product.setQuantity(resultSet.getInt("quantity"));
//				product.setStatus(resultSet.getBoolean("status"));
//				product.setDescription(resultSet.getString("description"));
//				product.setCreated(resultSet.getDate("created"));
//				products.add(product);
//			}
//		}catch (Exception e) {
//			products = null;
//		}finally {
//			ConnectDB.disconnect();
//		}
//		return products;
//	}
	
//	// Search by price
//		public List<Product> searchByPrice(double min , double max){
//			List<Product> products = new ArrayList<Product>();
//			try {
//				PreparedStatement preparedStatement = ConnectDB.connection()
//						.prepareStatement("select * from product where price >= ? and price <= ?");
//				preparedStatement.setDouble(1,min);
//				preparedStatement.setDouble(2,max);
//				ResultSet resultSet = preparedStatement.executeQuery();
//				while(resultSet.next()) {
//					Product product = new Product();
//					product.setId(resultSet.getInt("id"));
//					product.setName(resultSet.getString("name"));
//					product.setPrice(resultSet.getDouble("price"));
//					product.setQuantity(resultSet.getInt("quantity"));
//					product.setStatus(resultSet.getBoolean("status"));
//					product.setDescription(resultSet.getString("description"));
//					product.setCreated(resultSet.getDate("created"));
//					products.add(product);
//				}
//			}catch (Exception e) {
//				products = null;
//			}finally {
//				ConnectDB.disconnect();
//			}
//			return products;
//		}
		
		// Search by keyword
//		public List<Book> searchByKeyword(String keyword, double min , double max){
//			List<Book> books = new ArrayList<Book>();
//			try {
//				PreparedStatement preparedStatement = ConnectDB.connection()
//						.prepareStatement("select * from book where name like ? and price >= ? and price <= ?");
//				preparedStatement.setString(1, keyword + "%" );
//				preparedStatement.setDouble(2,min);
//				preparedStatement.setDouble(3,max);
//				ResultSet resultSet = preparedStatement.executeQuery();
//				while(resultSet.next()) {
//					Book book = new Book();
//					book.setId(resultSet.getInt("id"));
//					book.setName(resultSet.getString("name"));
//					book.setPrice(resultSet.getDouble("price"));
//					book.setQuantity(resultSet.getInt("quantity"));
//					book.setStatus(resultSet.getBoolean("status"));
//					book.setCreated(resultSet.getDate("created"));
//					books.add(book);
//				}
//			}catch (Exception e) {
//				books = null;
//			}finally {
//				ConnectDB.disconnect();
//			}
//			return books;
//		}	
//		
//		// Search by date(year,month,day)
//		public List<Book> searchByMonthAndYear(int year , int month , boolean status){
//			List<Book> books = new ArrayList<Book>();
//			try {
//				PreparedStatement preparedStatement = ConnectDB.connection()
//						.prepareStatement("select * from book where year(created) =? and month(created) = ? and status = ?");
//				preparedStatement.setInt(1,year);
//				preparedStatement.setInt(2,month);
//				preparedStatement.setBoolean(3,status);
//				ResultSet resultSet = preparedStatement.executeQuery();
//				while(resultSet.next()) {
//					Book book = new Book();
//					book.setId(resultSet.getInt("id"));
//					book.setName(resultSet.getString("name"));
//					book.setPrice(resultSet.getDouble("price"));
//					book.setQuantity(resultSet.getInt("quantity"));
//					book.setStatus(resultSet.getBoolean("status"));
//					book.setCreated(resultSet.getDate("created"));
//					books.add(book);
//				}
//			}catch (Exception e) {
//				books = null;
//			}finally {
//				ConnectDB.disconnect();
//			}
//			return books;
//		}
//		
//		// Search by date
//		public List<Book> searchByDate1(Date date){
//			List<Book> books = new ArrayList<Book>();
//			try {
//				PreparedStatement preparedStatement = ConnectDB.connection()
//						.prepareStatement("select * from book where created =?");
//				preparedStatement.setDate(1,new java.sql.Date(date.getTime()));
//				
//				ResultSet resultSet = preparedStatement.executeQuery();
//				while(resultSet.next()) {
//					Book book = new Book();
//					book.setId(resultSet.getInt("id"));
//					book.setName(resultSet.getString("name"));
//					book.setPrice(resultSet.getDouble("price"));
//					book.setQuantity(resultSet.getInt("quantity"));
//					book.setStatus(resultSet.getBoolean("status"));
//					book.setCreated(resultSet.getDate("created"));
//					books.add(book);
//				}
//			}catch (Exception e) {
//				books = null;
//			}finally {
//				ConnectDB.disconnect();
//			}
//			return books;
//		}
//		
//		// Search by date []
//		public List<Book> searchByDate2(Date startDate ,Date endDate){
//			List<Book> books = new ArrayList<Book>();
//			try {
//				PreparedStatement preparedStatement = ConnectDB.connection()
//						.prepareStatement("select * from book where created >=? and created <= ?");
//				preparedStatement.setDate(1,new java.sql.Date(startDate.getTime()));
//				preparedStatement.setDate(2,new java.sql.Date(endDate.getTime()));
//				ResultSet resultSet = preparedStatement.executeQuery();
//				while(resultSet.next()) {
//					Book book = new Book();
//					book.setId(resultSet.getInt("id"));
//					book.setName(resultSet.getString("name"));
//					book.setPrice(resultSet.getDouble("price"));
//					book.setQuantity(resultSet.getInt("quantity"));
//					book.setStatus(resultSet.getBoolean("status"));
//					book.setCreated(resultSet.getDate("created"));
//					books.add(book);
//				}
//			}catch (Exception e) {
//				books = null;
//			}finally {
//				ConnectDB.disconnect();
//			}
//			return books;
//		}
//		
//		// Find by Id
//		public Book findById(int id){
//			Book book = null;
//			try {
//				PreparedStatement preparedStatement = ConnectDB.connection()
//						.prepareStatement("select * from book where id = ?");
//				preparedStatement.setInt(1,id);
//				ResultSet resultSet = preparedStatement.executeQuery();
//				while(resultSet.next()) {
//					book = new Book();
//					book.setId(resultSet.getInt("id"));
//					book.setName(resultSet.getString("name"));
//					book.setPrice(resultSet.getDouble("price"));
//					book.setQuantity(resultSet.getInt("quantity"));
//					book.setStatus(resultSet.getBoolean("status"));
//					book.setCreated(resultSet.getDate("created"));					
//				}
//			}catch (Exception e) {
//				e.printStackTrace();
//				book = null;
//			}finally {
//				ConnectDB.disconnect();
//			}
//			return book;
//		}
//		
//		// Sum
//		public Double sum(int year){
//			double result = 0;
//			try {
//				PreparedStatement preparedStatement = ConnectDB.connection()
//						.prepareStatement("select sum(price*quantity) from book where year(created) =? ");
//			preparedStatement.setInt(1,year);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			resultSet.next();
//			result = resultSet.getDouble(1);
//			}catch (Exception e) {
//				e.printStackTrace();
//				result = 0;
//			}finally {
//				ConnectDB.disconnect();
//			}
//			return result;
//		}
//		
//		// Total
//		public Double total(){
//			double result = 0;
//			try {
//				PreparedStatement preparedStatement = ConnectDB.connection()
//						.prepareStatement("select sum(price * quantity) from product");
//			ResultSet resultSet = preparedStatement.executeQuery();
//			resultSet.next();
//			result = resultSet.getDouble(1);
//			}catch (Exception e) {
//				e.printStackTrace();
//				result = 0;
//			}finally {
//				ConnectDB.disconnect();
//			}
//			return result;
//		}
//		
//		// Min price
//		public Double min(){
//			double result = 0;
//			try {
//				PreparedStatement preparedStatement = ConnectDB.connection()
//						.prepareStatement("select min(price) from product");
//			ResultSet resultSet = preparedStatement.executeQuery();
//			resultSet.next();
//			result = resultSet.getDouble(1);
//			}catch (Exception e) {
//				e.printStackTrace();
//				result = 0;
//			}finally {
//				ConnectDB.disconnect();
//			}
//			return result;
//		}
//		
//		// Max price
//		public Double max(){
//			double result = 0;
//			try {
//				PreparedStatement preparedStatement = ConnectDB.connection()
//						.prepareStatement("select max(price) from product");
//			ResultSet resultSet = preparedStatement.executeQuery();
//			resultSet.next();
//			result = resultSet.getDouble(1);
//			}catch (Exception e) {
//				e.printStackTrace();
//				result = 0;
//			}finally {
//				ConnectDB.disconnect();
//			}
//			return result;
//		}
//		
//		// Average price
//		public Double average(){
//			double result = 0;
//			try {
//				PreparedStatement preparedStatement = ConnectDB.connection()
//						.prepareStatement("select avg(price) from product");
//			ResultSet resultSet = preparedStatement.executeQuery();
//			resultSet.next();
//			result = resultSet.getDouble(1);
//			}catch (Exception e) {
//				e.printStackTrace();
//				result = 0;
//			}finally {
//				ConnectDB.disconnect();
//			}
//			return result;
//		}
//		
//		

//		
//		
//		
//		
		

}
