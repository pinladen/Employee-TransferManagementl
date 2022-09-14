package com.entities;

public class Roles {
	private Integer roleId;
	private String name;
	private boolean status;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Roles(Integer roleId, String name, boolean status) {
		super();
		this.roleId = roleId;
		this.name = name;
		this.status = status;
	}
	
	public Roles() {
		super();
	}
	
	@Override
	public String toString() {
		return "Roles [roleId=" + roleId + ", name=" + name + ", status=" + status + "]";
	}
	
	
}
