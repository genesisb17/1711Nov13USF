package com.bank.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojos.User;
import com.bank.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper; 	

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	//	@Override
	//	public void init() throws ServletException {
	//		super.init();
	//		System.out.println("initializing login servlet");
	//		
	//		
	//	}

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

	}



	protected String servletConfigParam = null;
	//	
	//	@Override
	//	public void init(ServletConfig config) throws ServletException {
	//		super.init(config);
	//		
	//		System.out.println("intializing with params");
	//		this.servletConfigParam = config.getInitParameter("param");
	//		String servletContextParam = getServletContext().getInitParameter("myParam");
	//		System.out.println("config param = " + servletConfigParam);
	//		System.out.println("context param = "  + servletContextParam);
	//	}

	static Service service = new Service();
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("logging in - log in servlet");

		//Grab all paramenters, in this case only 1 JSON String
		Map<String, String[]> myMap = request.getParameterMap();

		//Get the the keySet from the map, returns a Set
		Set<String> txObject = myMap.keySet();

		//API for converting our JSON into a Java Object
		ObjectMapper jackson = new ObjectMapper();

		//Convert the the keySet into an array, then get the first element (index 0) from that set
		Object obj = txObject.toArray()[0];
		
		ArrayList<String> tx =  jackson.readValue(((String)obj), ArrayList.class);
	
		
		HttpSession session = request.getSession();


		String email = tx.get(0);
		String pass = tx.get(1);
		int id = service.validateUser(email);
		System.out.println(id);
		if(id < 0){

			String json = "pass";
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			out.write(json);

		}
		else{
			User u = service.login(id, pass);
			if(u == null){
				String json = "fail";
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				out.write(json);
			}
			else{
				session.setAttribute("user", u);
				
				
				ObjectMapper mapper = new ObjectMapper();
				
				String json = mapper.writeValueAsString(u);
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				out.write(json);
			
				/*
				// stored in a cookie on the client's browser
				System.out.println("Logging user " + u.toString());
			
				// the parameters are the name, and the actual object that you want to store in the session

				System.out.println("forwarding to home");
				request.getRequestDispatcher("app.html")
				.forward(request, response);
				
*/
			}
		}



	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("destroying login servlet");
	}




}
