package com.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entities.Employee;

import com.entities.Titles;

public class TitlesModel {
	// findAll
	public List<Titles> findAll(){
		List<Titles> titles = new ArrayList<Titles>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from titles");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Titles title = new Titles();
				title.setTitle_id(resultSet.getInt("title_id"));
				title.setTitle_name(resultSet.getString("title_name"));
				title.setSalaries(resultSet.getDouble("salaries"));
				title.setStatus(resultSet.getBoolean("status"));
				titles.add(title);
			}
		}catch (Exception e) {
			titles = null;
		}finally {
			ConnectDB.disconnect();
		}
		return titles;
	}
	
	// Find by Id
		public Titles findById(int id){
			Titles title = null;
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("select * from titles where title_id = ?");
				preparedStatement.setInt(1,id);
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					title = new Titles();
					title.setTitle_id(resultSet.getInt("title_id"));
					title.setTitle_name(resultSet.getString("title_name"));
					title.setSalaries(resultSet.getDouble("salaries"));
					title.setStatus(resultSet.getBoolean("status"));			
				}
			}catch (Exception e) {
				e.printStackTrace();
				title = null;
			}finally {
				ConnectDB.disconnect();
			}
			return title;
		}
		

		public boolean create(Titles title) {
			boolean result = true;
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("insert into titles(title_name,salaries,status) values(?,?,?) ");
				preparedStatement.setString(1, title.getTitle_name());
				preparedStatement.setDouble(2, title.getSalaries());
				preparedStatement.setBoolean(3, title.isStatus());
				result = preparedStatement.executeUpdate() > 0;

			} catch (Exception e) {
				e.printStackTrace();
				result = false;
			} finally {
				ConnectDB.disconnect();
			}
			return result;
		}

		// delete project
		public boolean delete(int titleId) {
			boolean result = true;
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("delete from titles where title_id = ? ");
				preparedStatement.setInt(1, titleId);
				result = preparedStatement.executeUpdate() > 0;

			} catch (Exception e) {
				e.printStackTrace();
				result = false;
			} finally {
				ConnectDB.disconnect();
			}
			return result;
		}

		// Update project
		public boolean update(Titles title) {
			boolean result = true;
			try {
				PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
						"update titles set title_name = ? , salaries = ? , status = ? where title_id  = ? ");
				preparedStatement.setString(1, title.getTitle_name());
				preparedStatement.setDouble(2, title.getSalaries());
				preparedStatement.setBoolean(3, title.isStatus());
				preparedStatement.setInt(4, title.getTitle_id());
				result = preparedStatement.executeUpdate() > 0;
				result = preparedStatement.executeUpdate() > 0;

			} catch (Exception e) {
				e.printStackTrace();
				result = false;
			} finally {
				ConnectDB.disconnect();
			}
			return result;
		}

		// Search by keyword
		public List<Titles> searchByKeyword(String keyword) {
			List<Titles> titles = new ArrayList<Titles>();
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("select * from titles where title_name like ? ");
				preparedStatement.setString(1, keyword + "%");

				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					Titles title = new Titles();
					title.setTitle_id(resultSet.getInt("title_id"));
					title.setTitle_name(resultSet.getString("title_name"));
					title.setSalaries(resultSet.getDouble("salaries"));
					title.setStatus(resultSet.getBoolean("status"));
					titles.add(title);
				}
			} catch (Exception e) {
				titles = null;
			} finally {
				ConnectDB.disconnect();
			}
			return titles;
		}

}
