package pojos;

public class Account {
	
	private int id;
	private double balance;
	
	public Account() {
		super();
		this.id = 0;
		this.balance = 0.0f;
	}
	
	public Account(int id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
