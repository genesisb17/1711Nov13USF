package com.ex;

import java.util.ArrayList;

public class Service 
{
	static ArrayList<User> users= new ArrayList<User>();
	static 
	{
		users.add(new User("test","123"));
		users.add(new User("Genesis","Bonds"));
		users.add(new User("admin","user"));
	}
	public ArrayList <User> getUsers()
	{
		return users;
	}
	public User validateUser(String username)
	{
		for(User u:users)
		{
			if(u.getUsername().equalsIgnoreCase(username))
			{
				return u;
			}
		}
		return null;
	}
	
}