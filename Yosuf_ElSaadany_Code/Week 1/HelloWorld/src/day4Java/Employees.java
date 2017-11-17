package day4Java;

public class Employees {

	int age;
	String FirstName;
	String LastName;
	String State;
	
	public Employees() {}
	
	
	public Employees(String FirstName, String LastName, String State, int age) {
		super();
		this.FirstName= FirstName;
		this.LastName = LastName;
		this.State = State;
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}


	
}
