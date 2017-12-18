package servlets;

import java.io.BufferedReader;
import java.io.IOException;
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

public class EnterServlet extends HttpServlet {
	static Service service = new Service();
	protected void doPost(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
		// 1. get received JSON data from request
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		System.out.println("JSON STRING: " + json);

		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();

		//// 3. Convert received JSON to String array
		
		String[] userInfo = mapper.readValue(json, String[].class);
		String username = userInfo[0];
		String password = userInfo[1];
		
		
		User temp = service.validateUser(username, password); // get user by uname
		if(temp.getId() != 0) {
			HttpSession session = req.getSession();
			session.setAttribute("user", temp);
			System.out.println("Before entering welcome servlet");
			RequestDispatcher rd = req.getRequestDispatcher("welcomeServlet");
			rd.forward(req, rep);
		}
		else {
			System.out.println("In else statment of EnterServlet");
			PrintWriter out = rep.getWriter();
			rep.setContentType("application/json");
			String userJSON = mapper.writeValueAsString(temp);
			out.write(userJSON);   
		}
	}
}
