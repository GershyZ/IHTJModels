package com.ihavethejokes.container;

import java.io.File; 
import java.util.Hashtable;

public abstract class Packable {
	public enum Status {NEW, PACKED, ON_ROUTE, AT_DESTINATION, UNPACKED};
	public static boolean PICTURE_REQUIRED = true;
	public static String ROW_TEMPLATE = "listview";
	String _name;
	boolean _fragile = false;
	Status _status;	
	String _description = "";
	File imgloc;

	public Packable(String name){
		_name = name;
		_status = Status.NEW;
	}

	public Packable(String name, String description){
		_name = name;
		_description =description;
		_status = Status.NEW;
	}

	public Packable(String name, String description, File img){
		_name = name;
		_description = description;
		imgloc = img;	
		_status = Status.NEW;
	}
	public void updateStatus(Status update){
		_status = update;
	}
	public String getName(){return _name;}
	public String getDescription(){return _description;}
	public Status getStatus(){return _status;}
	public File getImg(){ return imgloc;}		
	public Hashtable<String, Object> getInfo(){
		Hashtable<String,Object> info = new Hashtable<String, Object>();
		info.put("name", _name);
		info.put("description", _description);
		info.put("status", _status.toString());			
		return info;			
	}
	public abstract int getPackableBkgColor(Packable.Status s);

	public abstract int getRowPackableTemplate();
}
