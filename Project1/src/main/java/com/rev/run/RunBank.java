package com.rev.run;
import java.util.ArrayList;
import java.util.Scanner;
import com.rev.service.Service;

public class RunBank 
{
	static Service service = new Service();
	static int id;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Ready");
		run();
	}
	static void run()
	{
		service.connect();
	}
}