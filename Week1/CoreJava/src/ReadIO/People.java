package ReadIO;

public class People {
	/*
	 * In this class, I am giving the studnet object fields that we will need to read in
	 * from the data.txt file that will contain the information below
	 * 
	 * The data will be delimeted by the :, allowing for the extraction and storage of the data
	 * from the file to the program. 
	 * 
	 */
	private String firstName;
	private String lastName;
	private int age;
	private String state;
	


	public People(){};
	
	public People(String firstName, String lastName, int age, String state) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age= age;
		this.state = state;
		
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return firstName + ":" + lastName + ":" + age + ":" + state + "\n";
	}
	
	
}
