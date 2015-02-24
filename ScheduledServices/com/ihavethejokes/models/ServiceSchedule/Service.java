package com.ihavethejokes.models.ServiceSchedule;

public abstract class Service {
	protected final String name;
	
	public Service(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
