package com.real.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.real.util.ConnectionFactory;
import com.real.dao.DAO;
import com.real.dao.FileDAO;
import com.real.pojos.TableRow;
import com.real.pojos.User;

public class Service {
	
	static DAO dao = new FileDAO();

	public User addUser(User u) {
		if(isUser(u.getuName())) {
			System.out.println("In service.addUser(): already a user");
			return null;
		}
		dao.addUser(u);
		return u;
	}
	
	public User addReimbursement(User u, String[] rb) {
		dao.addReimbursement(u, rb);
		
		return u;
	}
	
	public User getUser(String uName) {
		if(!isUser(uName)) {
			System.out.println("In service.getUser(): not a user");
			return null;
		}
		return dao.getUser(uName);
	}
	
	public boolean isUser(String username) {
		if(username == "") return false;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from users where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username); // Goes by order of question marks
			ResultSet info = ps.executeQuery();	
			String cmp = "";
			while(info.next()) {
				cmp = info.getString(2);
				System.out.println(cmp);
			}
			if(username.equals(cmp))
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<TableRow> getReimbursements(User user) {
		return dao.getReimbursements(user);
	}
	
	public void updateReimbursement(String[] vals) {
		dao.updateReimbursement(vals);
	}
	
}