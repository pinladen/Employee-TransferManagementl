package com.entities;

import java.util.Date;

public class Department {
	private Integer depamentId;
	private String depamentName;
	private Date created;
	private boolean status;
	
	
	
	@Override
	public String toString() {
		return "depament [depamentId=" + depamentId + ", depamentName=" + depamentName + ", created=" + created
				+ ", status=" + status + "]";
	}



	public Integer getDepamentId() {
		return depamentId;
	}



	public void setDepamentId(Integer depamentId) {
		this.depamentId = depamentId;
	}



	public String getDepamentName() {
		return depamentName;
	}



	public void setDepamentName(String depamentName) {
		this.depamentName = depamentName;
	}



	public Date getCreated() {
		return created;
	}



	public void setCreated(Date created) {
		this.created = created;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}



	public Department() {
		super();
	}



	public Department(Integer depamentId, String depamentName, Date created, boolean status) {
		super();
		this.depamentId = depamentId;
		this.depamentName = depamentName;
		this.created = created;
		this.status = status;
	}
	
	
}
