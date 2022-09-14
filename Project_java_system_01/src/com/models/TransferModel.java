package com.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entities.Employee;

import com.entities.Roles;
import com.entities.Transfer;


public class TransferModel {
	public static List<Transfer> findAll() {
		String sql = "";
		List<Transfer> transfers = new ArrayList<Transfer>();
		sql = "SELECT * FROM transfer order by transfer_id desc";
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Transfer transfer = new Transfer();
				transfer.setTransfer_id(resultSet.getInt("transfer_id"));
				transfer.setLocation_id(resultSet.getInt("location_id"));
				transfer.setDepartment_id(resultSet.getInt("department_id"));
				transfer.setProject_id(resultSet.getInt("project_id"));
				transfer.setEmployee_id(resultSet.getInt("employee_id"));
				transfer.setCreated(resultSet.getDate("created"));
				transfer.setProcessing_date(resultSet.getDate("processing_date"));
				transfer.setStatus(resultSet.getInt("status"));
				transfers.add(transfer);
				
			} 
		} catch (Exception e) {
			transfers = null;
		} finally {
			if (ConnectDB.connection() != null)
				try {
					ConnectDB.connection().close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return transfers;
	}
	
	
	// Find by Id
		public Transfer findById(int id){
			Transfer transfer = null;
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("select * from transfer where transfer_id = ?");
				preparedStatement.setInt(1,id);
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					transfer = new Transfer();
					transfer.setTransfer_id(resultSet.getInt("transfer_id"));
					transfer.setLocation_id(resultSet.getInt("location_id"));
					transfer.setEmployee_id(resultSet.getInt("employee_id"));
					transfer.setDepartment_id(resultSet.getInt("department_id"));
					transfer.setProject_id(resultSet.getInt("project_id"));
					transfer.setCreated(resultSet.getDate("created"));
					transfer.setProcessing_date(resultSet.getDate("processing_date"));
					transfer.setStatus(resultSet.getInt("status"));	
				}
			}catch (Exception e) {
				e.printStackTrace();
				transfer = null;
			}finally {
				ConnectDB.disconnect();
			}
			return transfer;
		}
		
		// Find by Id and status (1)
			public Transfer findByEmployeeId(int employeeId , int status){
				Transfer transfer = null;
				try {
					PreparedStatement preparedStatement = ConnectDB.connection()
							.prepareStatement("select * from transfer where employee_id = ? and status = ? order by employee_id asc");
					preparedStatement.setInt(1,employeeId);
					preparedStatement.setInt(2,status);
					ResultSet resultSet = preparedStatement.executeQuery();
					while(resultSet.next()) {
						transfer = new Transfer();
						transfer.setTransfer_id(resultSet.getInt("transfer_id"));
						transfer.setLocation_id(resultSet.getInt("location_id"));
						transfer.setEmployee_id(resultSet.getInt("employee_id"));
						transfer.setDepartment_id(resultSet.getInt("department_id"));
						transfer.setProject_id(resultSet.getInt("project_id"));
						transfer.setCreated(resultSet.getDate("created"));
						transfer.setProcessing_date(resultSet.getDate("processing_date"));
						transfer.setStatus(resultSet.getInt("status"));	
					}
				}catch (Exception e) {
					e.printStackTrace();
					transfer = null;
				}finally {
					ConnectDB.disconnect();
				}
				return transfer;
			}
	
		
		 //Create Transfer
		public Transfer create(Transfer transfer){
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("insert into transfer(location_id,employee_id,department_id,project_id,created,status) values(?,?,?,?,?,?) ",Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, transfer.getLocation_id());
			preparedStatement.setInt(2, transfer.getEmployee_id());
			preparedStatement.setInt(3, transfer.getDepartment_id());
			preparedStatement.setInt(4, transfer.getProject_id());
			preparedStatement.setDate(5,new java.sql.Date(transfer.getCreated().getTime()));
			//preparedStatement.setDate(6,new java.sql.Date(transfer.getProcessing_date().getTime()));
			preparedStatement.setInt(6, transfer.getStatus());
			int affectedRows = preparedStatement.executeUpdate() ;
	        if (affectedRows == 0) {
	            throw new SQLException("Creating transfer failed, no rows affected.");
	        }
	        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	            	transfer.setTransfer_id(generatedKeys.getInt(1));
	            }
	            else {
	                throw new SQLException("Creating transfer failed, no ID obtained.");
	            }
	        }
			}catch (Exception e) {
				e.printStackTrace();
				transfer = null;
			}finally {
				ConnectDB.disconnect();
			}
			return transfer;
		}
//		
		// Update Transfer
		public boolean update(Transfer transfer){
			boolean result = true;
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("update transfer set location_id = ? , employee_id = ? , department_id = ? , project_id = ? , created = ? , processing_date = ? , status = ? where transfer_id  = ? ");
				preparedStatement.setInt(1, transfer.getLocation_id());
				preparedStatement.setInt(2, transfer.getEmployee_id());
				preparedStatement.setInt(3, transfer.getDepartment_id());
				preparedStatement.setInt(4, transfer.getProject_id());
				preparedStatement.setDate(5,new java.sql.Date(transfer.getCreated().getTime()));
				preparedStatement.setDate(6,new java.sql.Date(transfer.getProcessing_date().getTime()));
				preparedStatement.setInt(7, transfer.getStatus());
				preparedStatement.setInt(8, transfer.getTransfer_id());
			result = preparedStatement.executeUpdate() > 0;
			
			}catch (Exception e) {
				e.printStackTrace();
				result = false;
			}finally {
				ConnectDB.disconnect();
			}
			return result;
		}
		//---------------------------------------------------------------------
		// Search 
		// search By Employee Name
		
		public List<Transfer> searchByEmployeeId(int employeeId){
			List<Transfer> transfers = new ArrayList<Transfer>();
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("select * from transfer where employee_Id = ? order by transfer_id desc");
				preparedStatement.setInt(1,employeeId);
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					Transfer transfer = new Transfer();
					transfer.setTransfer_id(resultSet.getInt("transfer_id"));
					transfer.setLocation_id(resultSet.getInt("location_id"));
					transfer.setDepartment_id(resultSet.getInt("department_id"));
					transfer.setProject_id(resultSet.getInt("project_id"));
					transfer.setEmployee_id(resultSet.getInt("employee_id"));
					transfer.setCreated(resultSet.getDate("created"));
					transfer.setProcessing_date(resultSet.getDate("processing_date"));
					transfer.setStatus(resultSet.getInt("status"));
					
					transfers.add(transfer);
					System.out.println(transfer.toString());
				}
			}catch (Exception e) {
				transfers = null;
			}finally {
				ConnectDB.disconnect();
			}
			return transfers;
		}	
		
		// search by status
		public List<Transfer> searchByStatus(int status){
			List<Transfer> transfers = new ArrayList<Transfer>();
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("select * from transfer where status = ? ");
				preparedStatement.setInt(1,status);
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					Transfer transfer = new Transfer();
					transfer.setTransfer_id(resultSet.getInt("transfer_id"));
					transfer.setLocation_id(resultSet.getInt("location_id"));
					transfer.setDepartment_id(resultSet.getInt("department_id"));
					transfer.setProject_id(resultSet.getInt("project_id"));
					transfer.setEmployee_id(resultSet.getInt("employee_id"));
					transfer.setCreated(resultSet.getDate("created"));
					transfer.setProcessing_date(resultSet.getDate("processing_date"));
					transfer.setStatus(resultSet.getInt("status"));
					
					transfers.add(transfer);
					System.out.println(transfers.toString());
				}
			}catch (Exception e) {
				transfers = null;
			}finally {
				ConnectDB.disconnect();
			}
			return transfers;
		}	
		
		// search by status and employeeId
				public List<Transfer> searchByStatusAndEmployeeId(int status, int employeeid){
					System.out.println("idStauts : " + status);
					System.out.println("employeeid : " + employeeid);
					List<Transfer> transfers = new ArrayList<Transfer>();
					try {
						PreparedStatement preparedStatement = ConnectDB.connection()
								.prepareStatement("select * from transfer where status = ? and employee_id = ?");
						preparedStatement.setInt(1,status);
						preparedStatement.setInt(2,employeeid);
						ResultSet resultSet = preparedStatement.executeQuery();
						while(resultSet.next()) {
							Transfer transfer = new Transfer();
							transfer.setTransfer_id(resultSet.getInt("transfer_id"));
							transfer.setLocation_id(resultSet.getInt("location_id"));
							transfer.setDepartment_id(resultSet.getInt("department_id"));
							transfer.setProject_id(resultSet.getInt("project_id"));
							transfer.setEmployee_id(resultSet.getInt("employee_id"));
							transfer.setCreated(resultSet.getDate("created"));
							transfer.setProcessing_date(resultSet.getDate("processing_date"));
							transfer.setStatus(resultSet.getInt("status"));
							
							transfers.add(transfer);
							System.out.println(transfers.toString());
						}
					}catch (Exception e) {
						transfers = null;
					}finally {
						ConnectDB.disconnect();
					}
					return transfers;
				}	
		
		// search by locationId
			public List<Transfer> searchByLocationId(int locationId){
				List<Transfer> transfers = new ArrayList<Transfer>();
				try {
					PreparedStatement preparedStatement = ConnectDB.connection()
							.prepareStatement("select * from transfer where location_id = ? ");
					preparedStatement.setInt(1,locationId);
					ResultSet resultSet = preparedStatement.executeQuery();
					while(resultSet.next()) {
						Transfer transfer = new Transfer();
						transfer.setTransfer_id(resultSet.getInt("transfer_id"));
						transfer.setLocation_id(resultSet.getInt("location_id"));
						transfer.setDepartment_id(resultSet.getInt("department_id"));
						transfer.setProject_id(resultSet.getInt("project_id"));
						transfer.setEmployee_id(resultSet.getInt("employee_id"));
						transfer.setCreated(resultSet.getDate("created"));
						transfer.setProcessing_date(resultSet.getDate("processing_date"));
						transfer.setStatus(resultSet.getInt("status"));
						
						transfers.add(transfer);
						System.out.println(transfers.toString());
					}
				}catch (Exception e) {
					transfers = null;
				}finally {
					ConnectDB.disconnect();
				}
				return transfers;
			}	
			
			// search by locationId and employeeId
				public List<Transfer> searchByLocationIdAndEmpId(int locationId, int employeeId){
					List<Transfer> transfers = new ArrayList<Transfer>();
					try {
						PreparedStatement preparedStatement = ConnectDB.connection()
								.prepareStatement("select * from transfer where location_id = ? and employee_id = ?");
						preparedStatement.setInt(1,locationId);
						preparedStatement.setInt(2,employeeId);
						ResultSet resultSet = preparedStatement.executeQuery();
						while(resultSet.next()) {
							Transfer transfer = new Transfer();
							transfer.setTransfer_id(resultSet.getInt("transfer_id"));
							transfer.setLocation_id(resultSet.getInt("location_id"));
							transfer.setDepartment_id(resultSet.getInt("department_id"));
							transfer.setProject_id(resultSet.getInt("project_id"));
							transfer.setEmployee_id(resultSet.getInt("employee_id"));
							transfer.setCreated(resultSet.getDate("created"));
							transfer.setProcessing_date(resultSet.getDate("processing_date"));
							transfer.setStatus(resultSet.getInt("status"));
							
							transfers.add(transfer);
							System.out.println(transfers.toString());
						}
					}catch (Exception e) {
						transfers = null;
					}finally {
						ConnectDB.disconnect();
					}
					return transfers;
				}	
			
			// search by DepartmentId
			public List<Transfer> searchByDepartmentId(int departmentId){
				List<Transfer> transfers = new ArrayList<Transfer>();
				try {
					PreparedStatement preparedStatement = ConnectDB.connection()
							.prepareStatement("select * from transfer where department_id = ? ");
					preparedStatement.setInt(1,departmentId);
					ResultSet resultSet = preparedStatement.executeQuery();
					while(resultSet.next()) {
						Transfer transfer = new Transfer();
						transfer.setTransfer_id(resultSet.getInt("transfer_id"));
						transfer.setLocation_id(resultSet.getInt("location_id"));
						transfer.setDepartment_id(resultSet.getInt("department_id"));
						transfer.setProject_id(resultSet.getInt("project_id"));
						transfer.setEmployee_id(resultSet.getInt("employee_id"));
						transfer.setCreated(resultSet.getDate("created"));
						transfer.setProcessing_date(resultSet.getDate("processing_date"));
						transfer.setStatus(resultSet.getInt("status"));
						
						transfers.add(transfer);
						System.out.println(transfers.toString());
					}
				}catch (Exception e) {
					transfers = null;
				}finally {
					ConnectDB.disconnect();
				}
				return transfers;
			}	
			
			// search by DepartmentId and employeeId
				public List<Transfer> searchByDepartmentIdAndEmpId(int departmentId,int employeeId){
					List<Transfer> transfers = new ArrayList<Transfer>();
					try {
						PreparedStatement preparedStatement = ConnectDB.connection()
								.prepareStatement("select * from transfer where department_id = ? and employee_id = ? ");
						preparedStatement.setInt(1,departmentId);
						preparedStatement.setInt(2,employeeId);
						ResultSet resultSet = preparedStatement.executeQuery();
						while(resultSet.next()) {
							Transfer transfer = new Transfer();
							transfer.setTransfer_id(resultSet.getInt("transfer_id"));
							transfer.setLocation_id(resultSet.getInt("location_id"));
							transfer.setDepartment_id(resultSet.getInt("department_id"));
							transfer.setProject_id(resultSet.getInt("project_id"));
							transfer.setEmployee_id(resultSet.getInt("employee_id"));
							transfer.setCreated(resultSet.getDate("created"));
							transfer.setProcessing_date(resultSet.getDate("processing_date"));
							transfer.setStatus(resultSet.getInt("status"));
							
							transfers.add(transfer);
							System.out.println(transfers.toString());
						}
					}catch (Exception e) {
						transfers = null;
					}finally {
						ConnectDB.disconnect();
					}
					return transfers;
				}	
			
			// search by ProjectId
			public List<Transfer> searchByProjectId(int projectId){
				List<Transfer> transfers = new ArrayList<Transfer>();
				try {
					PreparedStatement preparedStatement = ConnectDB.connection()
							.prepareStatement("select * from transfer where project_id = ? ");
					preparedStatement.setInt(1,projectId);
					ResultSet resultSet = preparedStatement.executeQuery();
					while(resultSet.next()) {
						Transfer transfer = new Transfer();
						transfer.setTransfer_id(resultSet.getInt("transfer_id"));
						transfer.setLocation_id(resultSet.getInt("location_id"));
						transfer.setDepartment_id(resultSet.getInt("department_id"));
						transfer.setProject_id(resultSet.getInt("project_id"));
						transfer.setEmployee_id(resultSet.getInt("employee_id"));
						transfer.setCreated(resultSet.getDate("created"));
						transfer.setProcessing_date(resultSet.getDate("processing_date"));
						transfer.setStatus(resultSet.getInt("status"));
						
						transfers.add(transfer);
						System.out.println(transfers.toString());
					}
				}catch (Exception e) {
					transfers = null;
				}finally {
					ConnectDB.disconnect();
				}
				return transfers;
			}	
			
			// search by ProjectId
			public List<Transfer> searchByProjectIdAndEmpID(int projectId,int employeeId){
				List<Transfer> transfers = new ArrayList<Transfer>();
				System.out.println("prId :" + projectId);
				System.out.println("empID :" + employeeId);
				try {
					PreparedStatement preparedStatement = ConnectDB.connection()
							.prepareStatement("select * from transfer where project_id = ? and employee_id = ?");
					preparedStatement.setInt(1,projectId);
					preparedStatement.setInt(2,employeeId);
					ResultSet resultSet = preparedStatement.executeQuery();
					while(resultSet.next()) {
						Transfer transfer = new Transfer();
						transfer.setTransfer_id(resultSet.getInt("transfer_id"));
						transfer.setLocation_id(resultSet.getInt("location_id"));
						transfer.setDepartment_id(resultSet.getInt("department_id"));
						transfer.setProject_id(resultSet.getInt("project_id"));
						transfer.setEmployee_id(resultSet.getInt("employee_id"));
						transfer.setCreated(resultSet.getDate("created"));
						transfer.setProcessing_date(resultSet.getDate("processing_date"));
						transfer.setStatus(resultSet.getInt("status"));
						
						transfers.add(transfer);
						System.out.println("search by pr :" + transfers.toString());
					}
				}catch (Exception e) {
					transfers = null;
				}finally {
					ConnectDB.disconnect();
				}
				return transfers;
			}	
			
			// search by status
				public List<Transfer> searchByCreated(Date created){
					List<Transfer> transfers = new ArrayList<Transfer>();
					try {
						PreparedStatement preparedStatement = ConnectDB.connection()
								.prepareStatement("select * from transfer where created = ? ");
						preparedStatement.setDate(1,(java.sql.Date) created);
						ResultSet resultSet = preparedStatement.executeQuery();
						while(resultSet.next()) {
							Transfer transfer = new Transfer();
							transfer.setTransfer_id(resultSet.getInt("transfer_id"));
							transfer.setLocation_id(resultSet.getInt("location_id"));
							transfer.setDepartment_id(resultSet.getInt("department_id"));
							transfer.setProject_id(resultSet.getInt("project_id"));
							transfer.setEmployee_id(resultSet.getInt("employee_id"));
							transfer.setCreated(resultSet.getDate("created"));
							transfer.setProcessing_date(resultSet.getDate("processing_date"));
							transfer.setStatus(resultSet.getInt("status"));
							
							transfers.add(transfer);
							System.out.println(transfers.toString());
						}
					}catch (Exception e) {
						transfers = null;
					}finally {
						ConnectDB.disconnect();
					}
					return transfers;
				}	
		
		
		
		
//		
//		// delete role
//		public boolean delete(int roleId){
//			boolean result = true;
//			try {
//				PreparedStatement preparedStatement = ConnectDB.connection()
//						.prepareStatement("delete from roles where id = ? ");
//				preparedStatement.setInt(1, roleId);
//			result = preparedStatement.executeUpdate() > 0;
//			
//			}catch (Exception e) {
//				e.printStackTrace();
//				result = false;
//			}finally {
//				ConnectDB.disconnect();
//			}
//			return result;
//		}
	
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
