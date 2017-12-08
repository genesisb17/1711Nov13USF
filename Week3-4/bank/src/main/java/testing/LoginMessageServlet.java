package testing;

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

@WebServlet("/loginmessagetest")
public class LoginMessageServlet extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) 
					throws ServletException, IOException {
		System.out.println("testing -- POST");
		
		// Grab all params, even though in this case its
		// only 1 JSON string
		Map<String, String[]> myMap = req.getParameterMap();
		
		// Get the keyset from the map 
		Set<String> txObject = myMap.keySet();
		
		// use Jackson. API for converting JSON to java
		ObjectMapper jackson = new ObjectMapper();
		
		// convert our keyset into an array, then get
		// what we need from it
		Object obj = txObject.toArray()[0];
		ArrayList<String> tx = jackson.readValue(
				(String)obj, ArrayList.class);
		
		HttpSession session = req.getSession();
		Service service = new Service();
		
		String email = tx.get(0);
		String pass = tx.get(1);
		
		int id = service.validateUser(email);
		System.out.println("id = " + id);
		String json = "";
		if(id<0){ // if user DNE
			json = "Invalid user. Please try again";
		}
		else{
			User u = service.login(id, pass);
			if(u == null){
				json = "Incorrect Password. Please try again";
			}
			else{
				json = "success";
			}
		}
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
	}
	
}
