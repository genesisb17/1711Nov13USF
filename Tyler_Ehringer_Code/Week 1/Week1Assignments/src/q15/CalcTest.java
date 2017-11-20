package q15;

public class CalcTest {
	
	public static void main(String[] args) {
		double a = 124.141;
		double b = 44.425;
		
		Calculator c = new Calculator();
		
		System.out.println(c.addition(a, b));
		System.out.println(c.subtraction(a, b));
		System.out.println(c.multiplication(a, b));
		System.out.println(c.division(a, b));
	}

}
