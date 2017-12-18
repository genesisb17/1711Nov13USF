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

public class UpdatePassword extends HttpServlet {
			static Service service = new Service();
			
			protected void doPut(HttpServletRequest req, HttpServletResponse rep) 
					throws ServletException, IOException{
				
				BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
				String json="";
				if(br != null) {
					json= br.readLine();
				}
				
				ObjectMapper mapper = new ObjectMapper();
				
				String[] userInfo = mapper.readValue(json, String[].class);
				String username = userInfo[0];
				String password = userInfo[1];
				
				int update = service.updatePassword(username, password);
				if(update != 0) {
					System.out.println("Succesful Password Update");
					PrintWriter out = rep.getWriter();
					rep.setContentType("application/json");
					String userJSON = mapper.writeValueAsString(update);
					System.out.println(userJSON);
					out.write(userJSON); 
				}
				else {
					System.out.println("Update did not take place");
					PrintWriter out = rep.getWriter();
					rep.setContentType("application/json");
					String userJSON = mapper.writeValueAsString(update);
					System.out.println(userJSON);
					out.write(userJSON); 
				}
			}
}
