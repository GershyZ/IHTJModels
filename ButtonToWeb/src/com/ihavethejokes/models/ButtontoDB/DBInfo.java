package com.ihavethejokes.models.ButtontoDB;

import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;

public abstract class DBInfo {

	public static final String TAG_SUCCESS = "Success";
	public List<HashMap<String, Object>> data;	
	public String phpUrl;

	// JSON Node names
	public String TAG_LIST_TYPE = "";
	public String TAG_TYPE = "";
	public String TAG_ID;
	public String TAG_NAME;

	/**
	 * parseData
	 * get the query data and parse accordingly into a HashMap
 * @param jsonArray
	 */
	public void parseData(JSONArray jsonArray){	
		for (int i=0; i<jsonArray.length(); i++) {
			try {
				data.add(this.getEntry((JSONObject) jsonArray.get(i)));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * getFunction
	 * appends page function to URL of db connection
	 * @param string
	 * @return
	 */
	public String getFunction(String pageFunction){
		return phpUrl+"/"+pageFunction;
	}

	public abstract HashMap<String, Object> getEntry(JSONObject object);
	
	public abstract Bundle packBundle();
}
