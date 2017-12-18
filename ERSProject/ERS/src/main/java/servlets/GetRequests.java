package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import main.Service;
import pojos.DTO;
import pojos.User;

public class GetRequests extends HttpServlet{
			static Service service = new Service();
	protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
			String json="";
			if(br!= null) {
				json = br.readLine();
			}
			
			ObjectMapper mapper = new ObjectMapper();
			
			User u = mapper.readValue(json, User.class);
			
			ArrayList<DTO> dataset = service.getRequests(u);
			
			PrintWriter out = rep.getWriter();
			rep.setContentType("application/json");
			String userJSON = mapper.writeValueAsString(dataset);
			out.write(userJSON);
			
			}
	}

