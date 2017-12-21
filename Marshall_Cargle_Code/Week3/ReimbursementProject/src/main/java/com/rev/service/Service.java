package com.rev.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.rev.dao.DAO;
import com.rev.dao.JDBCDAO;
import com.rev.pojos.SpecTicket;
import com.rev.pojos.Ticket;
import com.rev.pojos.User;
import com.rev.util.ConnectionFactory;

public class Service {
	static DAO dao=new JDBCDAO();
	
	public User addUser(User u) {
		u=dao.addUser(u);
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
	
	public List<SpecTicket> getTickets(){
		return dao.getTickets();
	}
	
	public String SetPassword(String email, String oldPass, String newPass) {
		return dao.SetPassword(email, oldPass, newPass);
	}
	
	public String setAccount(int id, String email, String firstname, String lastname) {
		return dao.setAccount(id, email, firstname, lastname);
	}
	
	public List<SpecTicket> getUserTickets(int id){
		return dao.getUserTickets(id);
	}
	
	public void setTicket(int ticket_id, int resolver_id, Timestamp t, int status) {
		dao.setTicket(ticket_id, resolver_id, t, status);
	}
}
