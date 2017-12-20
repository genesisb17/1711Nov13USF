package com.ex.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ex.beans.Course;
import com.ex.beans.Instructor;
import com.ex.beans.Product;
import com.ex.beans.Student;
import com.ex.beans.Transcript;
import com.ex.util.ConnectionUtil;

public class hibDao
{
	public void addUser(User u)
	{
		Session session = ConnectionUtil.getSession();
		try
		{
			Transaction tx =(Transaction) session.beginTransaction();
			//int scriptid = (Integer) session.save(script);
			tx.commit();
		}
		finally
		{
			session.close();
		}
	}
	
}