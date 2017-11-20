package q18;

public class Child extends Base{

	@Override
	public boolean hasUpper(String s) {
		return !s.toLowerCase().equals(s);
	}

	@Override
	public String toUpper(String s) {
		return s.toUpperCase();
	}

	@Override
	public void addTen(String s) {
		System.out.println(Integer.parseInt(s) + 10);
	}
	
	public static void main(String[] args) {
		Base b = new Child();
		System.out.println(b.hasUpper("HeLlO"));
		System.out.println(b.hasUpper("goodbye"));
		System.out.println(b.toUpper("Totally tubulaR"));
		b.addTen("165");
	}

}
