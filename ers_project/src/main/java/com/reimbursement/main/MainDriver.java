package com.reimbursement.main;

import java.io.PrintWriter;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.pojos.Employee;
import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.services.Services;

public class MainDriver {


public static void main(String[] args){
	Services serv = new Services();
	
//	Employee e = new Employee();
//	e = serv.validateUser("gen");
//	System.out.println(e.toFile());

//	serv.makeReimb(33, "test", 18, 1);
	
//	serv.getAllR();
	ArrayList<Reimbursement> reimbs = new ArrayList<>();
	reimbs = serv.getRById(18);
//	for(Reimbursement res : tw) {
//		
//		System.out.println(res.toString());
//	}
	StringBuilder json = null;
	ObjectMapper mapper = new ObjectMapper();

		json = new StringBuilder();
		json.append("[");
		for (Reimbursement result: reimbs) {

		try {
			json.append(mapper.writeValueAsString(result));
			json.append(",");
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}
		json.replace(json.lastIndexOf(","), json.length(), "]");
//	PrintWriter out = response.getWriter();
//	response.setContentType("application/json");
	System.out.println(json);	
}	
	
}
