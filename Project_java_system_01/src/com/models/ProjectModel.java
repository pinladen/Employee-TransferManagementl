package com.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entities.Project;


public class ProjectModel {
	// findAll
	public List<Project> findAll(){
		List<Project> projects = new ArrayList<Project>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from project");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Project project = new Project();
				project.setProjectId(resultSet.getInt("project_id"));
				project.setProjectName(resultSet.getString("project_name"));
				project.setCreated(resultSet.getDate("created"));
				project.setStatus(resultSet.getBoolean("status"));
				projects.add(project);
			}
			
		}catch (Exception e) {
			projects = null;
		}finally {
			ConnectDB.disconnect();
		}
		return projects;
	}
	
	
	// Find by Id
		public Project findById(int id){
			Project project = null;
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("select * from project where project_id = ?");
				preparedStatement.setInt(1,id);
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					project = new Project();
					project.setProjectId(resultSet.getInt("project_id"));
					project.setProjectName(resultSet.getString("project_name"));
					project.setCreated(resultSet.getDate("created"));
					project.setStatus(resultSet.getBoolean("status"));	
				}
			}catch (Exception e) {
				e.printStackTrace();
				project = null;
			}finally {
				ConnectDB.disconnect();
			}
			return project;
		}
		
		
		 //Create project
		public boolean create(Project project){
			boolean result = true;
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("insert into project(project_name,created,status) values(?,?,?) ");
			preparedStatement.setString(1, project.getProjectName());
			preparedStatement.setDate(2,new java.sql.Date(project.getCreated().getTime()));
			preparedStatement.setBoolean(3, project.isStatus());
			result = preparedStatement.executeUpdate() > 0;
			
			}catch (Exception e) {
				e.printStackTrace();
				result = false;
			}finally {
				ConnectDB.disconnect();
			}
			return result;
		}
		
		// Update project
		public boolean update(Project project){
			System.out.println(project.toString());
			boolean result = true;
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("update project set project_name = ? , created = ? , status = ? where project_id  = ? ");
				preparedStatement.setString(1, project.getProjectName());
				preparedStatement.setDate(2,new java.sql.Date(project.getCreated().getTime()));
				preparedStatement.setBoolean(3, project.isStatus());
				preparedStatement.setInt(4, project.getProjectId());
			result = preparedStatement.executeUpdate() > 0;
			
			}catch (Exception e) {
				e.printStackTrace();
				result = false;
			}finally {
				ConnectDB.disconnect();
			}
			return result;
		}
		
		// delete project
		public boolean delete(int projectId){
			boolean result = true;
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("delete from project where project_id = ? ");
				preparedStatement.setInt(1, projectId);
			result = preparedStatement.executeUpdate() > 0;
			
			}catch (Exception e) {
				e.printStackTrace();
				result = false;
			}finally {
				ConnectDB.disconnect();
			}
			return result;
		}
		
		// Search by keyword
		public List<Project> searchByKeyword(String keyword) {
			List<Project> projects = new ArrayList<Project>();
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("select * from project where project_name like ? ");
				preparedStatement.setString(1, keyword + "%");

				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					Project project = new Project();
					project.setProjectId(resultSet.getInt("project_id"));
					project.setProjectName(resultSet.getString("project_name"));
					project.setCreated(resultSet.getDate("created"));
					project.setStatus(resultSet.getBoolean("status"));
					projects.add(project);
				}
			} catch (Exception e) {
				projects = null;
			} finally {
				ConnectDB.disconnect();
			}
			return projects;
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
