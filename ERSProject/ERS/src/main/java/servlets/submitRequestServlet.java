package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import pojos.DTO;
import main.Service;


public class submitRequestServlet extends HttpServlet{

	static Service service = new Service();
	
	protected void doPost(HttpServletResponse resp, HttpServletRequest req) throws ServletException, IOException {
		System.out.println("In submit request servlet");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String[] info = mapper.readValue(json, String[].class);
		double amount = Double.parseDouble(info[0]);
		String description = info[1];
		int type = Integer.parseInt(info[2]);
		int id = Integer.parseInt(info[3]);
		DTO data = new DTO();
		data.setId(id);
		data.setAmount(amount);
		data.setDescription(description);
		data.setType(type);
		
		int reqId = service.submitRequest(data);
		if(reqId !=0) {
			System.out.println("Succesfully Inserted!");
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			String userJSON = mapper.writeValueAsString(reqId);
			out.write(userJSON);
		}
		else {
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			String userJSON = mapper.writeValueAsString(reqId);
			out.write(userJSON);
			
		}
	}
}
