package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import main.Service;
import pojos.User;

public class emailValidator extends HttpServlet {
	static Service service = new Service();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException{
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		String[] userInfo = mapper.readValue(json, String[].class);
		String email = userInfo[0];
		
		System.out.println();
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user"); //lets you access the user that initiated the current session that your currently in (check loginservlet http session
		System.out.println("User in the getUserInfo servlet is " + user);
		
		
	}

}
