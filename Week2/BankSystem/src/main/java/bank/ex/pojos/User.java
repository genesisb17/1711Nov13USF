package bank.ex.pojos;

public class User {
	/* I decided to add more attributes to the user to make it more
	 * convenient when using the User object in the methods that would make updates
	 * to the User. 
	 */
	
	private int u_id;
	private String firstName;
	private String lastName;
	private String userName;
	private String passWord;
	private int acc_id;
	private double balance;
	
	public User() {};
	
	public User(int u_id, String firstName, String lastName, String userName, String passWord, int acc_id) {
		super();
		this.u_id= u_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.acc_id = acc_id;
		
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ "," + "acc_id=" + acc_id + ", balance=" + balance + "]";
	}


	
	
	
}
