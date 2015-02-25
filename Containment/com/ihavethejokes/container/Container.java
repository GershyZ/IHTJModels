package com.ihavethejokes.container;
/**
 * Gershon Zebovitz
 * SnapNPack v1.2
 * A container is an object that can hold items of type Packable
 * The items in these classes refer to indicies in an ArrayList at the top level.
 *  
 */

import java.util.ArrayList;

public interface Container {
    public static String ROW_TEMPLATE = "listview";
    
	public  enum Progress{ EMPTY, CONTAINS_ITEMS, PACKED, MOVED, REMOVING_ITEMS, IDLE};

	public boolean PICTURE_REQUIRED = false;
	
	public int getContentCount();
	
	public void packObject(int index);
	
	public int getContentIndex(int contentarrindex);
	
    public Packable[] getContentDetails(ArrayList<Packable> packables);
	
//	public Packable getContainedObject(int index);
	
	public void unpackObject(int index);
	
	public void updateProgress(Progress updated);

	public int getContainerRowTemplate();
}
