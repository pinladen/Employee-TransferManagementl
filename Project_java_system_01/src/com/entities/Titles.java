package com.entities;

import java.util.Date;

public class Titles {
	private Integer title_id;
	private String title_name;
	private double salaries;
	private boolean status;
	public Integer getTitle_id() {
		return title_id;
	}
	public void setTitle_id(Integer title_id) {
		this.title_id = title_id;
	}
	public String getTitle_name() {
		return title_name;
	}
	public void setTitle_name(String title_name) {
		this.title_name = title_name;
	}
	public double getSalaries() {
		return salaries;
	}
	public void setSalaries(double salaries) {
		this.salaries = salaries;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Titles(Integer title_id, String title_name, double salaries, boolean status) {
		super();
		this.title_id = title_id;
		this.title_name = title_name;
		this.salaries = salaries;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Titles [title_id=" + title_id + ", title_name=" + title_name + ", salaries=" + salaries + ", status="
				+ status + "]";
	}
	
	public Titles() {
		super();
	}
	
	
}
