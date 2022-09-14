package com.entities;

import java.util.Arrays;
import java.util.Date;

public class Employee {
	private Integer employeeId;
	private String name;
	private Date dob;
	private String phone ;
	private String email ;
	private byte[] image ;
	private String gender;
	private Date createdAt;
	private String username ;
	private String password ;
	private Integer roleId;
	private Integer titleId;
	private boolean status;
	
	

	public Integer getEmployeeId() {
		return employeeId;
	}





	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public Date getDob() {
		return dob;
	}





	public void setDob(Date dob) {
		this.dob = dob;
	}





	public String getPhone() {
		return phone;
	}





	public void setPhone(String phone) {
		this.phone = phone;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public byte[] getImage() {
		return image;
	}





	public void setImage(byte[] image) {
		this.image = image;
	}





	public String getGender() {
		return gender;
	}





	public void setGender(String gender) {
		this.gender = gender;
	}





	public Date getCreatedAt() {
		return createdAt;
	}





	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}





	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public Integer getRoleId() {
		return roleId;
	}





	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}





	public Integer getTitleId() {
		return titleId;
	}





	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}





	public boolean isStatus() {
		return status;
	}





	public void setStatus(boolean status) {
		this.status = status;
	}





	public Employee() {
		super();
	}





	public Employee(Integer employeeId, String name, Date dob, String phone, String email, byte[] image, String gender,
			Date createdAt, String username, String password, Integer roleId, Integer titleId, boolean status) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.image = image;
		this.gender = gender;
		this.createdAt = createdAt;
		this.username = username;
		this.password = password;
		this.roleId = roleId;
		this.titleId = titleId;
		this.status = status;
	}





	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", dob=" + dob + ", phone=" + phone
				+ ", email=" + email + ", image=" + Arrays.toString(image) + ", gender=" + gender + ", createdAt="
				+ createdAt + ", username=" + username + ", password=" + password + ", roleId=" + roleId + ", titleId="
				+ titleId + ", status=" + status + "]";
	}
	

	
	
	
}
