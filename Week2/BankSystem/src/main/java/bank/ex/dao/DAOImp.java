package bank.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import bank.ex.pojos.User;
import bank.ex.utility.ConnectionFactory;

public class DAOImp implements DAO {
	@Override
	public void viewAccounts(User client){
		/*This method runs an sql command that returns all of the accounts
		 * under the user based on their user ID. Instead of returning something
		 * to the user interface, the method prints all of the information in this 
		 * layer.
		 */
		try(Connection conn = ConnectionFactory.getINstance().getConnection();){
			String sql ="select * from ACCOUNTS where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, client.getU_id());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Account Number: " + rs.getInt(1) + " Balance: " + rs.getDouble(3));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	@Override
	public int accountAmount(User client) {
		/*This method is used to determine how many accounts the 
		 * user currently has. With this method, we are able to determine
		 * whether or not user is allowed to create any more accounts
		 * since they are only limited to being able to have (2) per user. 
		 */
		int total = 0;
		try(Connection conn = ConnectionFactory.getINstance().getConnection();){
			String sql = "select count(*) from ACCOUNTS where USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, client.getU_id());
			ResultSet amount = ps.executeQuery();
			amount.next();
			total = amount.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	@Override
	public int existingAccount(int accountID) {
		/*This method is used to determine whether or not the
		 * user input an actual account ID. This is beneficial to the
		 * methods that require account ID as part of their parameters
		 * (UpdateAccountBalance). This ensures that nothing wrong takes 
		 * place because user input incorrect account id. Should return (1)
		 * if account exists
		 */
		int total = 0;
		try(Connection conn= ConnectionFactory.getINstance().getConnection();){
			String sql = "select count(*) from ACCOUNTS where acc_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, accountID);
			ResultSet amount = ps.executeQuery();
			amount.next();
			total = amount.getInt(1);
			if(total == 0) {
				System.out.println("Account does not exist\n");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	@Override
	public double accountBalance(int accountID) {
		/*This method returns the account balance for the account
		 * based on the accountID input by the user. Before running this function
		 * the existingAccount function is called to determine if account ID
		 * the user input is valid or not. 
		 */
			double accountBalance=0;
		try(Connection conn = ConnectionFactory.getINstance().getConnection();){
			String sql = "select balance from ACCOUNTS where acc_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, accountID);
			ResultSet rs = ps.executeQuery();
			rs.next();
			accountBalance = rs.getDouble(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountBalance;
	}
	@Override
	public void addAccount(User client, double balance) {	
		/*This method adds an account for the user. Right before this method,
		 * the accountAmount method is called to ensure that the user has 
		 * not exceeded the 2 accounts per user limit .
		 */
		try(Connection conn = ConnectionFactory.getINstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "insert into ACCOUNTS (USER_ID, BALANCE) values (?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, client.getU_id());
			ps.setDouble(2, balance);
			ps.executeUpdate();
			conn.commit();
			System.out.println("Account successfully created!\n");
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
	
	}
 	@Override
	public User login(User client) {
 		/*The user interface layer calls this function via a DAO object. 
 		 * this is the method that will determine whether the given 
 		 * user name and password match in the database.
 		 */
		User usr = new User();
		try(Connection conn = ConnectionFactory.getINstance().getConnection();){
			String sql = "select * from Users where username = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, client.getUserName().toLowerCase());
			ps.setString(2, client.getPassWord());
			ResultSet userInfo = ps.executeQuery();
			if(!userInfo.isBeforeFirst()) {
				System.out.println("Login failed. Try again.");
				usr.setUserName("NA");
				return usr;
			}
			while(userInfo.next()) {
				usr.setU_id(userInfo.getInt(1));
				usr.setFirstName(userInfo.getString(2));
				usr.setLastName(userInfo.getString(3));
				usr.setUserName(userInfo.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usr;
	}
	@Override
 	public User addUser(User client) {
		/*This method adds a user to the database based on the given 
		 * they input for the user. User is unable to successfully create
		 * an account if they input a username that is already taken.
		 */
		User usr = new User();
		try(Connection conn = ConnectionFactory.getINstance().getConnection();){
			conn.setAutoCommit(false);
			System.out.println("In the add user method");
			String sql = "insert into USERS (FIRSTNAME,LASTNAME,USERNAME,PASSWORD) values (?,?,?,?)";
			String[] key = new String[1];
			key[0]= "u_id";
			System.out.println("before prepared statement in add user method");
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, client.getFirstName());
			ps.setString(2, client.getLastName());
			ps.setString(3, client.getUserName()); //.toLowerCase the user entry in main.
			ps.setString(4, client.getPassWord());
			System.out.println("Before execute update statement in add user method");
			int rows = ps.executeUpdate(); // returns the number of rows updated
			System.out.println("Number of rows after execute update: " + rows);
			if(rows != 0) {
				/* this is to acquire Primary Key and set it to user that will be returned after function
				 * runs. This will make it easier to access multiple accounts if user has more than one account.
				 * 
				 */
				ResultSet primaryKey = ps.getGeneratedKeys();
				while(primaryKey.next()) {
					usr.setU_id(primaryKey.getInt(1));
				}
				conn.commit();
				System.out.println("User succesfully created! You can now log in!");
			}
				
		} catch (SQLException e) {
			/*Since there is already a UNIQUE constraint placed for
			 * whenever creating a username, if someone is to enter
			 * a username that is already created, it would fall 
			 * under SQLException, which explains why the username is not 
			 * available message is printing from there. 
			 */
			e.printStackTrace();
			System.out.println("Username not available. Please try signing up again.\n");
			usr.setUserName("null");
			return usr;
			
		}
		return usr;
	}
	@Override
	public void updateAccountBalance(double newBalance, int accountID) {
		try(Connection conn = ConnectionFactory.getINstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "update accounts set balance = ? where acc_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, newBalance);
			ps.setInt(2, accountID);
			ps.executeUpdate();
			conn.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public void updateUser(User client) {
		
		try(Connection conn = ConnectionFactory.getINstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "update USERS set firstname = ?, lastname = ?, username = ? where u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, client.getFirstName());
			ps.setString(2, client.getLastName());
			ps.setString(3, client.getUserName());
			ps.setInt(4, client.getU_id());
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
