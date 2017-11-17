package com.revature.designpatterns;

public class ToolFactory {

	public Tool workWithTool(String toolType) {
		
		switch(toolType.toLowerCase()) {
		
		case "hammer":	return new Hammer();
		case "saw":		return new Saw();
		case "wrench":	return new Wrench();
		default:		return null;
		
		}
		
	}
	
}
