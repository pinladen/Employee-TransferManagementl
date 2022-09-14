package com.entities;

public class Location {
	private Integer locationId;
	private String locationName;
	private String streetAddress;
	private boolean status;
	public Location(Integer locationId, String locationName, String streetAddress, boolean status) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.streetAddress = streetAddress;
		this.status = status;
	}
	public Location() {
		super();
	}
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationName=" + locationName + ", streetAddress="
				+ streetAddress + ", status=" + status + "]";
	}
	
	
	
}
