package servlets;

import javax.servlet.annotation.WebServlet; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.User;
import main.Service;
import com.fasterxml.jackson.databind.ObjectMapper;


public class RegisterServlet extends HttpServlet{

	static Service service = new Service();
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			System.out.println("In register servlet");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
			String json = "";
			if(br!=null) {
				json=br.readLine();
			}
			ObjectMapper mapper = new ObjectMapper();
			
			User u = mapper.readValue(json,User.class);
			System.out.println("Username in Register Servlet is " + u.getUsername());
			/*function that will take the User U, and send to jdbc 
				and write it to the database.
			register function from 
			*/
			
			u = service.addUser(u);
			
	}
}
