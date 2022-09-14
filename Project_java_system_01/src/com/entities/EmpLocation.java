package com.entities;

import java.util.Date;

public class EmpLocation {
	private Integer id;
	private Integer employeeId;
	private Integer locationId;
	private Date fromDate;
	private Date toDate;
	private String description;
	
	
	
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



	public Integer getLocationId() {
		return locationId;
	}



	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
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



	public EmpLocation(Integer id, Integer employeeId, Integer locationId, Date fromDate, Date toDate,
			String description) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.locationId = locationId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.description = description;
	}



	public EmpLocation() {
		super();
	}



	@Override
	public String toString() {
		return "EmpLocation [id=" + id + ", employeeId=" + employeeId + ", locationId=" + locationId + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", description=" + description + "]";
	}
	
	

	
	
}
