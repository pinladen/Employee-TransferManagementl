package com.entities;

public class EmployeeCustom {
	private Employee employee;
	private Location location;
	private Department depament;
	private Project project;
	
	
	
	
	@Override
	public String toString() {
		return "EmployeeCustom [employee=" + employee + ", location=" + location + ", depament=" + depament
				+ ", project=" + project + "]";
	}

	public EmployeeCustom() {
		super();
	}

	public EmployeeCustom(Employee employee, Location location, Department depament, Project project) {
		super();
		this.employee = employee;
		this.location = location;
		this.depament = depament;
		this.project = project;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Department getDepament() {
		return depament;
	}

	public void setDepament(Department depament) {
		this.depament = depament;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	
}
