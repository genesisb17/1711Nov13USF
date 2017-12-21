package com.rev.dao;

import java.sql.Timestamp;
import java.util.List;

import com.rev.pojos.SpecTicket;
import com.rev.pojos.Ticket;
import com.rev.pojos.User;

public interface DAO {
	User addUser(User u);
	Ticket addTicket(Ticket t);
	User getUser(String Email, String password);
	List<SpecTicket> getTickets();
	String setAccount(int id, String email, String firstname, String lastname);
	void setTicket(int ticket_id, int resolver_id, Timestamp t, int status);
	String SetPassword(String email, String oldPass, String newPass);
	List<SpecTicket> getUserTickets(int id);
}
