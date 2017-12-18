package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import main.Service;
import pojos.User;

public class UpdateProfile extends HttpServlet {
		static Service service = new Service();
	
	protected void doPut(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json="";
		if(br!=null) {
			json=br.readLine();
		}
		ObjectMapper mapper = new ObjectMapper();
		
		User update = mapper.readValue(json,User.class);
		System.out.println("FirstName: " + update.getFirstname() + " LastName: " + update.getLastname()
		+ " Email: " + update.getEmail() + " username " + update.getUsername());
		
		User newUser = service.updateUser(update.getUsername(), update.getFirstname(), update.getLastname(), update.getEmail());
		if(update.getUsername().equals(newUser.getUsername())) {
			newUser.setId(update.getId());
			newUser.setUserroleid(update.getUserroleid());
			System.out.println(newUser);
			HttpSession session = req.getSession();
			session.setAttribute("user", newUser);
			ObjectMapper mapOut = new ObjectMapper();
			PrintWriter out = rep.getWriter();
			rep.setContentType("application/json");
			String userJSON = mapOut.writeValueAsString(newUser);
			out.write(userJSON);  
		}
		else {
			update.setId(0);
			System.out.println("Update did not take place");
			PrintWriter out = rep.getWriter();
			rep.setContentType("application/json");
			String userJSON = mapper.writeValueAsString(update);
			out.write(userJSON);  
		}
		
		
	}
	

}
