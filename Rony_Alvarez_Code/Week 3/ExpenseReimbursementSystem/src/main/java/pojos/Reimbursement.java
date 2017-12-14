package pojos;

import java.sql.Timestamp;

public class Reimbursement {

	private int id;
	private String username;
	private int amount;
	private Timestamp submitted;
	private String description;
	private String type;
	private String status;
	
	public Reimbursement() {}

	public Reimbursement(int id, String username, int amount, Timestamp submitted, String description, String type,
			String status) {
		super();
		this.id = id;
		this.username = username;
		this.amount = amount;
		this.submitted = submitted;
		this.description = description;
		this.type = type;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
