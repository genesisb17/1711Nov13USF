package com.rev.dao;

import java.util.List;

import com.rev.pojos.SpecTicket;
import com.rev.pojos.Ticket;
import com.rev.pojos.User;

public interface DAO {
	User addUser(User u);
	Ticket addTicket(Ticket t);
	User getUser(String Email, String password);
	List<SpecTicket> getTickets();
	User setAccount(User u);
	Ticket setTicket(Ticket t);
	String SetPassword(String email, String oldPass, String newPass);
}
