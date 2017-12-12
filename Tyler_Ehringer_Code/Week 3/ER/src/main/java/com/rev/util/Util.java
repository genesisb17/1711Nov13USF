package com.rev.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;

import javax.servlet.ServletInputStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.dao.DAO;
import com.rev.dao.DAOImplementation;

public class Util {
	
	public static String getJson(ServletInputStream in) {
		return  (new BufferedReader(new InputStreamReader(in))).lines().reduce("", (a, b) -> a + b);
	}
	
	public static Iterator<String> path(String s){
		Iterator<String> result =  Arrays.asList(s.split("/")).iterator();
		result.next();
		result.next();
		return result;
	}
	
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		DAO service = new DAOImplementation();
		try {
			System.out.println(mapper.writeValueAsString(service.getReimbursements()));
		} catch (JsonProcessingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
