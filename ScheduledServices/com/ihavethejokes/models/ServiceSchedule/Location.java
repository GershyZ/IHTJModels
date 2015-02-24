package com.ihavethejokes.models.ServiceSchedule;


public class Location{
	
	protected String name;
	protected String address;
	protected String zipcode;
	
	protected Schedule schedule;
	
	public Location(String name, String address, String zipcode){
		this.name = name;
		this.address = address;
		this.zipcode = zipcode;				
	}
	/**
	 * isAvailable
	 * Check the location's schedule and the meal's schedule to see if 
	 * the location has food for a certain time
	 * @return
	 */
	public boolean isAvailable(){
		return true;
	}
}