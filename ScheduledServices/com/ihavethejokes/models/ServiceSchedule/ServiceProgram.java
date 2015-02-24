package com.ihavethejokes.models.ServiceSchedule;

import java.io.File;

import org.json.simple.JSONArray;

public interface ServiceProgram {
	public void importDataFromCsv(File csvFile);	
	public void importDataFromRowset(JSONArray rowset);
}
