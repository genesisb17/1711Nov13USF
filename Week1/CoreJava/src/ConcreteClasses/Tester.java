package ConcreteClasses;

import ConcreteClasses.ConcreteEx;
public class Tester {

	public static void main(String[] args) {
		ConcreteEx testIt = new ConcreteEx();
		System.out.println(testIt.upperCaseChecker("heard You"));
		System.out.println(testIt.lowerToUpperCase("Lets get this money for the hood!"));
		testIt.stringToInt("21");
		
		
	}

}
