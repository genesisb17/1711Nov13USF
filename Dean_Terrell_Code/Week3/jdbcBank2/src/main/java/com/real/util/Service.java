package com.real.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.real.util.ConnectionFactory;
import com.real.dao.DAO;
import com.real.dao.FileDAO;
import com.real.pojos.User;

public class Service {
	
	static DAO dao = new FileDAO();

	public User addUser(User u) {
		dao.addUser(u);
		return u;
	}
	
	public User getUser(String uName) {
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
				cmp = info.getString(4);
			}
			if(username.equals(cmp))
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void updateBalance(User u, double newValue) {
		dao.updateBalance(u, newValue);
	}
	
}