package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojos.Ticket;
import com.rev.pojos.User;

public interface DAO {
	User addUser(User u);
	Ticket addTicket(Ticket t);
	User getUser(String Email, String password);
	Ticket getTicket(int ticket_ID);
	ArrayList<Ticket> getTickets(String email);
	User setEmail(User u, String Email);
}
