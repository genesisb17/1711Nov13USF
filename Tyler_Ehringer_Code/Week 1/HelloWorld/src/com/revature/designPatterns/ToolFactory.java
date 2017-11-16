package com.revature.designPatterns;

public class ToolFactory {

	public Tool workWtihTool(String toolType) {
		switch(toolType.toLowerCase()) {
		case "hammer": return new Hammer();
		case "screwdriver": return new Screwdriver();
		default: return null;
		}
	}
}
