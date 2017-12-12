package com.rev.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.rev.pojos.R_Status;
import com.rev.pojos.R_Type;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;
import com.rev.util.ConnectionFactory;

public class DBDAO implements DAO {

	@Override
	public ArrayList<Reimbursement> getReimbursements() {
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from REIMBURSEMENT";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setId(rs.getInt(1)); // Index starts at 1
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitted(rs.getDate(3).toString());
				try { temp.setResolved(rs.getDate(4).toString()); }
				catch (Exception e) {temp.setResolved(null);}
				temp.setDescription(rs.getString(5));
				temp.setReceipt(rs.getBlob(6));
				temp.setAuthor(rs.getInt(7));
				temp.setResolver(rs.getInt(8));
				temp.setStatus(rs.getInt(9));
				temp.setType(rs.getInt(10));
				temp.setAuthorStr(getFirstAndLastById(temp.getAuthor()));
				temp.setResolverStr(getFirstAndLastById(temp.getResolver()));
				temp.setStatusStr(getR_Status(temp.getStatus()));
				temp.setTypeStr(getR_Type(temp.getType()));
				reimbursements.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	public ArrayList<Reimbursement> getPendingReimbursements() {

		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from REIMBURSEMENT where r_status_id=0";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setId(rs.getInt(1)); // Index starts at 1
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitted(rs.getDate(3).toString());
				try { temp.setResolved(rs.getDate(4).toString()); }
				catch (Exception e) {temp.setResolved(null);}
				temp.setDescription(rs.getString(5));
				temp.setReceipt(rs.getBlob(6));
				temp.setAuthor(rs.getInt(7));
				temp.setResolver(rs.getInt(8));
				temp.setStatus(rs.getInt(9));
				temp.setType(rs.getInt(10));
				temp.setAuthorStr(getFirstAndLastById(temp.getAuthor()));
				temp.setResolverStr(getFirstAndLastById(temp.getResolver()));
				temp.setStatusStr(getR_Status(temp.getStatus()));
				temp.setTypeStr(getR_Type(temp.getType()));
				reimbursements.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbursements;
	}

	public Reimbursement addReimbursement(Reimbursement r) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "insert into Reimbursement (r_amount, r_description, r_author, r_status_id, r_type_id) values (?, ?, ?, 0, ?)";
			String[] key = new String[2];
			key[0] = "r_id";
			key[1] = "r_submitted";

			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setDouble(1, r.getAmount());
			ps.setString(2, r.getDescription());
			ps.setInt(3, r.getAuthor());
			ps.setInt(4, r.getType());
			int rows = ps.executeUpdate(); // could set variable to track that the update happened
			if (rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next()) {
					r.setId(pk.getInt(1));
					r.setSubmitted(pk.getDate(2).toString());
				}
				return r;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User addUser(User user) {
		System.out.println("adding user:" + user.toString());
		User temp = new User();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false); // Set to false to make sure it has properly changed
			String sql = "insert into users (username, password, firstname, lastname, email, role_id) values (?, ?, ?, ?, ?, ?)";
			String[] key = new String[1];
			key[0] = "user_id";

			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstname());
			ps.setString(4, user.getLastname());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getRole());
			int rows = ps.executeUpdate(); // could set variable to track that the update happened
			if (rows != 0) {
				System.out.println("in adduser if");
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next()) {
					temp.setId(pk.getInt(1));
				}
				temp.setFirstname(user.getFirstname());
				temp.setLastname(user.getLastname());
				temp.setUsername(user.getUsername());
				temp.setPassword(user.getPassword());
				temp.setEmail(user.getEmail());
				temp.setRole(user.getRole());
				temp.setRoleStr(getUser_Role(user.getRole()));
				conn.commit();
				return temp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("returning");
		return null;
	}

	public ArrayList<Reimbursement> getUserReimbursements(int id) {
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from reimbursement where r_author = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setId(rs.getInt(1)); // Index starts at 1
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitted(rs.getDate(3).toString());
				try { temp.setResolved(rs.getDate(4).toString()); }
				catch (Exception e) {temp.setResolved(null);}
				temp.setDescription(rs.getString(5));
				temp.setReceipt(rs.getBlob(6));
				temp.setAuthor(rs.getInt(7));
				temp.setResolver(rs.getInt(8));
				temp.setStatus(rs.getInt(9));
				temp.setType(rs.getInt(10));
				temp.setAuthorStr(getFirstAndLastById(temp.getAuthor()));
				temp.setResolverStr(getFirstAndLastById(temp.getResolver()));
				temp.setStatusStr(getR_Status(temp.getStatus()));
				temp.setTypeStr(getR_Type(temp.getType()));
				reimbursements.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbursements;
	}

	public Reimbursement getReimbursement(int r_id) {
		Reimbursement temp = new Reimbursement();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from REIMBURSEMENT where r_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				temp.setId(rs.getInt(1)); // Index starts at 1
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitted(rs.getDate(3).toString());
				try { temp.setResolved(rs.getDate(4).toString()); }
				catch (Exception e) {temp.setResolved(null);}
				temp.setDescription(rs.getString(5));
				temp.setReceipt(rs.getBlob(6));
				temp.setAuthor(rs.getInt(7));
				temp.setResolver(rs.getInt(8));
				temp.setStatus(rs.getInt(9));
				temp.setType(rs.getInt(10));
				temp.setAuthorStr(getFirstAndLastById(temp.getAuthor()));
				temp.setResolverStr(getFirstAndLastById(temp.getResolver()));
				temp.setStatusStr(getR_Status(temp.getStatus()));
				temp.setTypeStr(getR_Type(temp.getType()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public Reimbursement updateReimbursement(int r_id, int r_res, int r_status) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "{call RUPDATE(?, ?, ?)}"; // First is return
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, r_id);
			cs.setInt(2, r_res);
			cs.setInt(3, r_status);
			cs.execute();

			return getReimbursement(r_id);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUser(String username, String password) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from USERS where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User temp = new User();
				temp.setId(rs.getInt(1)); // Index starts at 1
				temp.setUsername(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setFirstname(rs.getString(4));
				temp.setLastname(rs.getString(5));
				temp.setEmail(rs.getString(6));
				temp.setRole(rs.getInt(7));
				temp.setRoleStr(getUser_Role(temp.getRole()));
				return temp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getR_Status(int r_id) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select R_STATUS from REIMBURSEMENT_STATUS where R_STATUS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getR_Type(int r_id) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select R_TYPE from REIMBURSEMENT_TYPE where R_TYPE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getUser_Role(int ur_id) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select ROLE from USER_ROLES where ROLE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ur_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean checkUsername(String username) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select COUNT(USERNAME) from USERS where USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) > 0) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkEmail(String email) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select COUNT(EMAIL) from USERS where EMAIL = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) > 0) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getFirstAndLastById(int id) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select FIRSTNAME, LASTNAME from USERS where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String fn = rs.getString(1);
				String ln = rs.getString(2);
				String name = fn + " " + ln;
				return name;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public ArrayList<R_Type> getAllRTypes() {
		ArrayList<R_Type> types = new ArrayList<R_Type>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from REIMBURSEMENT_TYPE";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				R_Type temp = new R_Type(rs.getInt(1), rs.getString(2));
				types.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return types;
	}

	@Override
	public ArrayList<R_Status> getAllRStatus() {
		ArrayList<R_Status> statusList = new ArrayList<R_Status>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from REIMBURSEMENT_STATUS";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				R_Status temp = new R_Status(rs.getInt(1), rs.getString(2));
				statusList.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statusList;
	}
}
