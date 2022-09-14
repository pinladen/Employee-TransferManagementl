package com.entities;

import java.util.Date;

public class Empdepartment {
	private Integer id;
	private Integer employeeId;
	private Integer departmentId;
	private Date fromDate;
	private Date toDate;
	private String description;
	
	
	public Empdepartment(Integer id, Integer employeeId, Integer departmentId, Date fromDate, Date toDate,
			String description) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.departmentId = departmentId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.description = description;
	}


	public Empdepartment() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}


	public Integer getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}


	public Date getFromDate() {
		return fromDate;
	}


	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}


	public Date getToDate() {
		return toDate;
	}


	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Empdepartment [id=" + id + ", employeeId=" + employeeId + ", departmentId=" + departmentId
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", description=" + description + "]";
	}
	
	
	

}
