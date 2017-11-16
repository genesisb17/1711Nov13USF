package com.revature.designPatterns;

import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {
		Singleton single = Singleton.getInstance();
		single.hello();
		
		ToolFactory tbf = new ToolFactory();
		Scanner s = new Scanner(System.in);
		System.out.println("Choose a tool: ");
		System.out.println(tbf.workWtihTool(s.nextLine().trim()).work());
	}

}
