package com.revature.ers.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.service.Service;

public class ValidationHelper {

	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("[LOG] - Processing validation request");
		Service service = new Service();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if(br != null) {
			json = br.readLine();
		}

		ObjectMapper mapper = new ObjectMapper();

		switch(request.getRequestURI()) {

		case "/ers/email.validate":

			String email = mapper.readValue(json, String.class);

			if(service.isEmailAddressAvailable(email)) {
				return email;
			}

			else {
				return null;
			}

		case "/ers/username.validate":

			String username = mapper.readValue(json, String.class);

			if(service.isUsernameAvailable(username)) {
				return username;
			}

			else {
				return null;
			}

		default:
			return null;
		}
	}

}