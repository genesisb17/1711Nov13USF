package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import main.Service;
import pojos.User;

public class PasswordVerify extends HttpServlet {
	
	static Service service = new Service();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse rep) 
			throws ServletException, IOException{
		
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}

		ObjectMapper mapper = new ObjectMapper();
		
		String[] userInfo = mapper.readValue(json, String[].class);
		String username = userInfo[0];
		String password = userInfo[1];
		
		User temp = service.validateUser(username, password);
		if(temp.getId() != 0) {
			PrintWriter out = rep.getWriter();
			rep.setContentType("application/json");
			String userJSON = mapper.writeValueAsString(temp);
			System.out.println(userJSON);
			out.write(userJSON); 
		}
		else {
			temp.setId(0);
			PrintWriter out = rep.getWriter();
			rep.setContentType("application/json");
			String userJSON = mapper.writeValueAsString(temp);
			System.out.println(userJSON);
			out.write(userJSON); 
		}
		
	}

}
