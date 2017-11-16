package com.revature.designpatterns;

public class ToolFactory {
	public Tool workwithTool(String ToolType)
	{
		switch(ToolType.toLowerCase()){
		case "hammer": return new Hammer();
		case "wrench": return new Wrench();
		
		default: return null;
		}
	}

}
