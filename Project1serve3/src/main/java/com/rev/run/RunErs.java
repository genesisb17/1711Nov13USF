package com.rev.run;

import java.util.ArrayList;
import java.util.Scanner;

import com.rev.pojo.R;
import com.rev.service.Service;

public class RunErs 
{
	static Service service = new Service();
	static int id;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//works
		//service.adders_user_roles("s");
		//service.addRStatus("test");
		//service.addRtype("test1");
		//System.out.println(service.getRtype(22));
		//System.out.println(service.getRStatus(22));
		//System.out.println(service.geters_user_roles(7));
		//service.adders_users("test1", "test1", "test1", "test1", "test1", 7);//might need work
		//System.out.println(service.geters_users("test1", "test1").getUid());
		//service.addReimbursements(100.20,"testing1",12,22,22,12);
		System.out.println(service.getReimbursements("test1", "test1").get(1).getReimb_Amount());


		
		
//not working
		
		

		
		int i =1;
		//doesn't work

	}
}