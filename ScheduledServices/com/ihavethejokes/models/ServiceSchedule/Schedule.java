package com.ihavethejokes.models.ServiceSchedule;

public abstract class Schedule {
	protected String begin;
	protected String end;
	
	/**
	 * parseAvailability
	 * parse to get better info on schedules	 
	 */
	public abstract void parseAvailability();
	
	/**
	 * checks if the current time fits in the schedule
	 * @return boolean
	 */
	public boolean isAvailable(){
		return false;
	}
}
