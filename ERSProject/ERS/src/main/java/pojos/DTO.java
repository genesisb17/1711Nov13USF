package pojos;
import java.sql.*;

public class DTO {
	private int id;
	private double amount;
	private Timestamp submitted;
	private Timestamp resolved;
	private String description;
	private int creator;
	private int resolver;
	private int status;
	private int type;
	
	public DTO () {};
	
	public DTO (int id, double amount, Timestamp submitted, Timestamp resolved, String description, int creator, int resolver, int status, int type) {
		super();
		this.id=id;
		this.amount = amount;
		this.submitted=submitted;
		this.resolved=resolved;
		this.description=description;
		this.creator=creator;
		this.resolver=resolver;
		this.status=status;
		this.type=type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCreator() {
		return creator;
	}

	public void setCreator(int creator) {
		this.creator = creator;
	}

	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "DTO [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", creator=" + creator + ", resolver=" + resolver + ", status="
				+ status + ", type=" + type + "]";
	}
	

}
