package com.rev.servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.rev.controllers.LoginController;
import com.rev.controllers.RegisterController;
import com.rev.controllers.ReimbursementsController;
import com.rev.util.Util;

@WebServlet("/*")
public class TServlet extends DefaultServlet{

	private static final long serialVersionUID = 1801022153802309402L;
	
	private static LoginController log = new LoginController();
	private static RegisterController reg = new RegisterController();
	private static ReimbursementsController reimb = new ReimbursementsController();
	
	
	/*
	 *  post /er/login/login              --login, ([username: string, password: string])
	 *  get  /er/login/logout             --logout, ()
	 *  
	 *  get  /er/reimbursements/all       --get all reimbursements (manager), ()
	 *  get  /er/reimbursements/user      --get user's reimbursements (employee), ()
	 *  post /er/reimbursements/add       --create new reimbursement (employee), (r: Reimbursement)
	 *  post /er/reimbursements/update     --update reimbursement (manager), (r: Reimbursement, resolverId: number, status: number, appendDescription: string)
	 *  
	 *  post /er/register/new             --create new user
	 *  post /er/register/update          --update user info
	 *  get  /er/register/username        --is username taken
	 *  get  /er/register/email           --is email taken
	 *  
	 *  
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		Iterator<String> path = Util.path(req.getRequestURI());
		if(path.hasNext()) {
			switch (path.next()) {
			case "login":
				log.handleGet(path, req, resp);
				break;
			case "reimbursements":
				reimb.handleGet(path, req, resp);
				break;
			case "register":
				reg.handleGet(path, req, resp);
				break;
			default:
				break;
			}
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		Iterator<String> path = Util.path(req.getRequestURI());
		if(path.hasNext()) {
			switch (path.next()) {
			case "login":
				log.handlePost(path, req, resp);
				break;
			case "reimbursements":
				reimb.handlePost(path, req, resp);
				break;
			case "register":
				reg.handlePost(path, req, resp);
				break;
			default:
				break;
			}
		}
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		resp.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, OPTIONS, DELETE");
		resp.setHeader("Access-Control-Allow-Headers", "X-Requested-With, content-type");
		resp.setHeader("Access-Control-Allow-Credentials", "true");
		super.service(req, resp);
	}

}
