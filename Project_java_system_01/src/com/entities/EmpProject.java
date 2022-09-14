package com.entities;

import java.util.Date;

public class EmpProject {
	private Integer id;
	private Integer employeeId;
	private Integer projectId;
	private Date fromDate;
	private Date toDate;
	private String description;
	public EmpProject(Integer id, Integer employeeId, Integer projectId, Date fromDate, Date toDate,
			String description) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.projectId = projectId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.description = description;
	}
	public EmpProject() {
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
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
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
		return "EmpProject [id=" + id + ", employeeId=" + employeeId + ", projectId=" + projectId + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", description=" + description + "]";
	}
	
	
	
	
	
	

	
	
}
