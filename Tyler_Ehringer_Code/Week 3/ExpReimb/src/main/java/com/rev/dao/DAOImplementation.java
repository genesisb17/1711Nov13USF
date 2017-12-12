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
			if (ps.executeQuery().next())
				return true;
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
				u = new User(rs.getInt("ers_user_id"), rs.getInt("user_role_id"),
						rs.getString("ers_username"), rs.getString("ers_password"), rs.getString("user_email"),
						rs.getString("ers_first_name"), rs.getString("ers_last_name"));
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
				u = new User(rs.getInt("ers_user_id"), rs.getInt("user_role_id"),
						rs.getString("ers_username"), rs.getString("ers_password"), rs.getString("user_email"),
						rs.getString("ers_first_name"), rs.getString("ers_last_name"));
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
				u = new User(rs.getInt("ers_user_id"), rs.getInt("user_role_id"),
						rs.getString("ers_username"), rs.getString("ers_password"), rs.getString("user_email"),
						rs.getString("ers_first_name"), rs.getString("ers_last_name"));
			}
		}
		return u;
	}

	@Override
	public List<Reimbursement> getReimbursementsForUser(int userId) throws SQLException {
		List<Reimbursement> l = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"select reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, "
							+ "reimb_resolver, reimb_status_id, reimb_type_id from ers_reimbursement where reimb_author = ?");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				l.add(new Reimbursement(rs.getInt("reimb_id"), rs.getInt("reimb_author"), rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id"), rs.getDouble("reimb_amount"),
						rs.getTimestamp("reimb_submitted"), rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"), null));
			}
		}
		return l;
	}

	@Override
	public List<Reimbursement> getReimbursements() throws SQLException {
		List<Reimbursement> l = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			ResultSet rs = conn.createStatement().executeQuery(
					"select reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, "
							+ "reimb_resolver, reimb_status_id, reimb_type_id from ers_reimbursement");
			while (rs.next()) {
				l.add(new Reimbursement(rs.getInt("reimb_id"), rs.getInt("reimb_author"), rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id"), rs.getDouble("reimb_amount"),
						rs.getTimestamp("reimb_submitted"), rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"), null));
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
	public Reimbursement addReimbursement(Reimbursement r) throws SQLException {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String[] keys = { "reimb_id", "reimb_status_id", "reimb_submitted" };
			PreparedStatement ps = conn.prepareStatement("insert into ers_reimbursement (reimb_amount, "
					+ "reimb_description, reimb_author, reimb_resolver, " + "reimb_type_id) values (?, ?, ?, ?, ?)",
					keys);
			ps.setDouble(1, r.getAmount());
			ps.setString(2, r.getDescription());
			ps.setInt(3, r.getAuthorId());
			ps.setInt(4, r.getResolverId());
			ps.setInt(5, r.getType());
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
	public Reimbursement updateReimbursement(Reimbursement r, int resolverId, int status,
			String appendDescription) throws SQLException {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String[] keys = { "reimb_resolved" };
			PreparedStatement ps = conn.prepareStatement(
					"update ers_reimbursement set (reimb_resolver = ?, reimb_status_id = ?, "
							+ "reimb_description = coalesce(reimb_description, '') || ':' || coalesce(?, '') where reimb_id = ?",
					keys);
			ps.setInt(1, resolverId);
			ps.setInt(2, status);
			ps.setString(3, appendDescription);
			ps.setInt(4, r.getId());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				r.setResolverId(resolverId);
				r.setStatus(status);
				r.setDescription(r.getDescription() + ":" + appendDescription);
				r.setResolved(rs.getTimestamp(1));
			}
		}
		return r;
	}
}
