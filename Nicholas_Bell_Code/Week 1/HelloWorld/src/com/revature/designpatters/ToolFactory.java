package com.revature.designpatters;

public class ToolFactory {
	public Tool workwithTool(String toolType) {
		switch(toolType.toLowerCase()) {
		case "hammer": return new Hammer();
		case "wrench": return new Wrench();
		default: return null;
		}
	}
}
