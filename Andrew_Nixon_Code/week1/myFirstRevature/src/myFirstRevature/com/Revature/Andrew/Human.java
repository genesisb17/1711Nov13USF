package myFirstRevature.com.Revature.Andrew;

public class Human extends Animal {

	private int age;
	private String hairColor;
	private double height;
	
	public Human() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public void consume(String... substance) {
		// TODO Auto-generated method stub

	}

	
	
	

}
