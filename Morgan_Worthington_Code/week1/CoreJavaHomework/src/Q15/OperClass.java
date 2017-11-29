package Q15;

public class OperClass implements Operations {

	
	
	@Override
	public int add(int num1, int num2) {
		return num1+num2;
	}

	@Override
	public int subtract(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1-num2;
	}

	@Override
	public int multiply(int num1, int num2) {
		
		return num1*num2;
	}

	@Override
	public int divide(int num1, int num2) {
		
		return num1/num2;
	}

}
