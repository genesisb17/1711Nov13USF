package com.rev.service;

import com.rev.dao.DAO;
import com.rev.dao.JDBCDAO;
import com.rev.pojos.Ticket;
import com.rev.pojos.User;

public class Service {
	static DAO dao=new JDBCDAO();
	
	public User addUser(User u) {
		dao.addUser(u);
		return u;
	}
	
	public Ticket addTicket(Ticket t) {
		dao.addTicket(t);
		return t;
	}
	
	public User getUser(String e, String p) {
		User u=dao.getUser(e, p);
		return u;
	}
}
