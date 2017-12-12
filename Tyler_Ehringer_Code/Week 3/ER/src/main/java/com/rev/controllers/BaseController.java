package com.rev.controllers;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.dao.DAO;
import com.rev.dao.DAOImplementation;

public abstract class BaseController {
	
	protected static DAO service = new DAOImplementation();
	protected static ObjectMapper mapper = new ObjectMapper();
	
	public void handlePost(Iterator<String> path, HttpServletRequest req, HttpServletResponse resp) {}
	public void handleGet(Iterator<String> path, HttpServletRequest req, HttpServletResponse resp) {}

}
