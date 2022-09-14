package com.entities;

import java.util.Date;

public class Project {
	private Integer projectId;
	private String projectName;
	private Date created;
	private boolean status;
	
	
	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", created=" + created + ", status="
				+ status + "]";
	}



	public Integer getProjectId() {
		return projectId;
	}



	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}



	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
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



	public Project() {
		super();
	}



	public Project(Integer projectId, String projectName, Date created, boolean status) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.created = created;
		this.status = status;
	}
	
	
}
