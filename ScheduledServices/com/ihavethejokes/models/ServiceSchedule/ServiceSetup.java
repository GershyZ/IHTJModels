package com.ihavethejokes.models.ServiceSchedule;

import java.io.File;
import java.util.ArrayList;

import org.json.simple.JSONArray;

public abstract class ServiceSetup implements ServiceProgram{
	ArrayList<Location> locations;
	ArrayList<Service> services;
	ArrayList<Schedule> schedules;
	
	String programname;
	
	public ServiceSetup(String name){
		programname = name;
		locations = new ArrayList<Location>();
		services = new ArrayList<Service>();
		schedules = new ArrayList<Schedule>();
	}
	
	@Override
	public void importDataFromCsv(File csvFile){
		
	}
	
	@Override
	public void importDataFromRowset(JSONArray rowset){
		
	}
	
	/**
	public Location addLocation(String name, String address, String zipcode){
		
	}
	
	public Schedule addSchedule(){
		
	}
	
	public Service addService(){
		
	}
	**/
}
