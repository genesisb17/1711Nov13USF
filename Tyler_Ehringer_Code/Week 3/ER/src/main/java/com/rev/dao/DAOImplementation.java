package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;
import com.rev.util.ConnectionFactory;

public class DAOImplementation implements DAO {
	@Override
	public boolean hasUsername(String username) throws SQLException {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement("select ers_users_id from ers_users where ers_username = ?");
			ps.setString(1, username.toLowerCase());
			if (ps.executeQuery().next()) return true;
		}
		return false;
	}

	@Override
	public boolean hasEMail(String email) throws SQLException {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement("select ers_users_id from ers_users where user_email = ?");
			ps.setString(1, email.toLowerCase());
			if (ps.executeQuery().next())
				return true;
		}
		return false;
	}

	@Override
	public User getUserByUsername(String username) throws SQLException {
		User u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from ers_users where ers_username = ?");
			ps.setString(1, username.toLowerCase());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				u = new User(rs.getInt("ers_users_id"), rs.getInt("user_role_id"), rs.getString("ers_username"),
						rs.getString("ers_password"), rs.getString("user_email"), rs.getString("user_first_name"),
						rs.getString("user_last_name"));
			}
		}
		return u;
	}

	@Override
	public User getUserByEmail(String email) throws SQLException {
		User u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from ers_users where user_email = ?");
			ps.setString(1, email.toLowerCase());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				u = new User(rs.getInt("ers_users_id"), rs.getInt("user_role_id"), rs.getString("ers_username"),
						rs.getString("ers_password"), rs.getString("user_email"), rs.getString("user_first_name"),
						rs.getString("user_last_name"));
			}
		}
		return u;
	}

	@Override
	public User getUserById(int id) throws SQLException {
		User u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from ers_users where ers_users_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				u = new User(rs.getInt("ers_users_id"), rs.getInt("user_role_id"), rs.getString("ers_username"),
						rs.getString("ers_password"), rs.getString("user_email"), rs.getString("user_first_name"),
						rs.getString("user_last_name"));
			}
		}
		return u;
	}

	@Override
	public List<Reimbursement> getReimbursementsForUser(int userId) throws SQLException {
		List<Reimbursement> l = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"select r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, r.reimb_author, "
							+ "r.reimb_resolver, r.reimb_status_id, r.reimb_type_id, u1.user_first_name || ' ' || u1.user_last_name as authorname, "
							+ "u2.user_first_name || ' ' || u2.user_last_name as resolvername from ers_reimbursement r inner join ers_users u1 on "
							+ "r.reimb_author = u1.ers_users_id left join ers_users u2 on r.reimb_resolver = u2.ers_users_id where reimb_author = ?");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reimbursement r = new Reimbursement(rs.getInt("reimb_id"), rs.getInt("reimb_author"), rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"), rs.getDouble("reimb_amount"),
						rs.getTimestamp("reimb_submitted"), rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"), null);
				r.setResolverName(rs.getString("resolvername"));
				r.setAuthorName(rs.getString("authorname"));
				l.add(r);
			}
		}
		return l;
	}

	@Override
	public List<Reimbursement> getReimbursements() throws SQLException {
		List<Reimbursement> l = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			ResultSet rs = conn.createStatement().executeQuery(
					"select r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, r.reimb_author, "
							+ "r.reimb_resolver, r.reimb_status_id, r.reimb_type_id, u1.user_first_name || ' ' || u1.user_last_name as authorname, "
							+ "u2.user_first_name || ' ' || u2.user_last_name as resolvername from ers_reimbursement r inner join ers_users u1 on"
							+ " r.reimb_author = u1.ers_users_id left join ers_users u2 on r.reimb_resolver = u2.ers_users_id");
			while (rs.next()) {
				Reimbursement r = new Reimbursement(rs.getInt("reimb_id"), rs.getInt("reimb_author"), rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"), rs.getDouble("reimb_amount"),
						rs.getTimestamp("reimb_submitted"), rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"), null);
				r.setResolverName(rs.getString("resolvername"));
				r.setAuthorName(rs.getString("authorname"));
				l.add(r);
			}
		}
		return l;
	}

	@Override
	public User addUser(User u) throws SQLException {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String[] keys = { "ers_users_id" };
			PreparedStatement ps = conn
					.prepareStatement("insert into ers_users (ers_username, ers_password, user_first_name, "
							+ "user_last_name, user_email, user_role_id) values (?, ?, ?, ?, ?, ?)", keys);
			ps.setString(1, u.getUsername().toLowerCase());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFname());
			ps.setString(4, u.getLname());
			ps.setString(5, u.getEmail());
			ps.setInt(6, u.getRole());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next())
				u.setId(rs.getInt(1));
		}
		return u;
	}
	
	@Override
	public User updateUser(User u) throws SQLException{
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement("update ers_users set ers_username = ?, ers_password = ?, user_email = ? where ers_users_id = ?");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setInt(4, u.getId());
			ps.executeUpdate();
		}
		return u;
	}

	@Override
	public Reimbursement addReimbursement(Reimbursement r) throws SQLException {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String[] keys = { "reimb_id", "reimb_status_id", "reimb_submitted" };
			PreparedStatement ps = conn.prepareStatement("insert into ers_reimbursement (reimb_amount, "
					+ "reimb_description, reimb_author, reimb_type_id) values (?, ?, ?, ?)",
					keys);
			ps.setDouble(1, r.getAmount());
			ps.setString(2, r.getDescription());
			ps.setInt(3, r.getAuthorId());
			ps.setInt(4, r.getType());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				r.setId(rs.getInt(1));
				r.setStatus(rs.getInt(2));
				r.setSubmitted(rs.getTimestamp(3));
			}
		}
		return r;
	}

	@Override
	public Reimbursement updateReimbursement(Reimbursement r)
			throws SQLException {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String[] keys = { "reimb_resolved" };
			PreparedStatement ps = conn.prepareStatement(
					"update ers_reimbursement set reimb_resolver = ?, reimb_status_id = ?, reimb_description = ? where reimb_id = ?",
					keys);
			ps.setInt(1, r.getResolverId());
			ps.setInt(2, r.getStatus());
			ps.setString(3, r.getDescription());
			ps.setInt(4, r.getId());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				r.setResolved(rs.getTimestamp(1));
			}
		}
		return r;
	}
	
	public static void main(String[] args) throws SQLException {
		DAO d = new DAOImplementation();
		d.addUser(new User(2, "tyler", "ty", "tyler@gmail.com", "Tyler", "Ehringer"));
		System.out.println(d.hasUsername("tyler"));
	}

}
