package InterfaceCreation;

public class InterfaceImplementer implements ArithmeticInter {
	/* This class implements the ArithmeticInter interface.
	 * because it is implemented, all of the abstract methods need to be
	 * accounted for and given a body in the class implementing the interface.
	 * in this case, the methods are
	 * 
	 * 1)Addition
	 * 2)Subtraction
	 * 3)Multiplication
	 * 4)Division
	 * 
	 * ****** IN ORDER TO USE THE METHODS< YOU MUST INSTANTIATE AN OBJECT OF THE CLASS
	 * 		  IMPLEMENTING THE INTERFACE *****
	 * 
	 */

	public static void main(String[] args) {
		InterfaceImplementer tester = new InterfaceImplementer();
		tester.addition(15,16);
		tester.subtraction(62, 31);
		tester.multiplication(5, 6);
		tester.division(30,10);
	}

	@Override
	public int addition(int x, int y) {
		// TODO Auto-generated method stub
		return x+y;
	}

	@Override
	public int subtraction(int x, int y) {
		// TODO Auto-generated method stub
		return x-y;
	}

	@Override
	public int multiplication(int x, int y) {
		// TODO Auto-generated method stub
		return x*y;
	}

	@Override
	public double division(int x, int y) {
		// TODO Auto-generated method stub
		return x/y;
	}

	
}
