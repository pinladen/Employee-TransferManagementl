package com.entities;

import java.util.Date;

public class Transfer {
	private Integer transfer_id;
	private Integer location_id;
	private Integer department_id;
	private Integer project_id;
	private Integer employee_id;
	private Date created;
	private Date processing_date;
	private Integer status;
	
	
	public Integer getTransfer_id() {
		return transfer_id;
	}
	public void setTransfer_id(Integer transfer_id) {
		this.transfer_id = transfer_id;
	}
	public Integer getLocation_id() {
		return location_id;
	}
	public void setLocation_id(Integer location_id) {
		this.location_id = location_id;
	}
	public Integer getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	public Integer getProject_id() {
		return project_id;
	}
	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getProcessing_date() {
		return processing_date;
	}
	public void setProcessing_date(Date processing_date) {
		this.processing_date = processing_date;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Transfer(Integer transfer_id, Integer location_id, Integer department_id, Integer project_id,
			Integer employee_id, Date created, Date processing_date, Integer status) {
		super();
		this.transfer_id = transfer_id;
		this.location_id = location_id;
		this.department_id = department_id;
		this.project_id = project_id;
		this.employee_id = employee_id;
		this.created = created;
		this.processing_date = processing_date;
		this.status = status;
	}
	public Transfer() {
		super();
	}
	
	@Override
	public String toString() {
		return "Transfer [transfer_id=" + transfer_id + ", location_id=" + location_id + ", department_id="
				+ department_id + ", project_id=" + project_id + ", employee_id=" + employee_id + ", created=" + created
				+ ", processing_date=" + processing_date + ", status=" + status + ", getTransfer_id()="
				+ getTransfer_id() + ", getLocation_id()=" + getLocation_id() + ", getDepartment_id()="
				+ getDepartment_id() + ", getProject_id()=" + getProject_id() + ", getEmployee_id()=" + getEmployee_id()
				+ ", getCreated()=" + getCreated() + ", getProcessing_date()=" + getProcessing_date() + ", getStatus()="
				+ getStatus() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
}
