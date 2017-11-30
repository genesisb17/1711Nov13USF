package day2demo;

public class VariableScopes {
	
	/*
	 * instance variables have default values
	 */
	boolean boolInst;
	byte byteInst;
	short shortInst;
	int intInst;
	long longInst;
	float floatInst;
	double doubleInst;
	char charInst;
	Object objInst;

	
	// class vars aka static
	static int counter;
	static boolean isActive;
	
	static{
		System.out.println("this is a static initializer");
	}

	public static void main(String[] args) {
		//System.out.println("int instance var default = " + intInst);
		System.out.println("int static var default =  " + counter);
		test(1);
		}
	
	static void test(int methodscopeint){
		methodscopeint = 0;
		int anothermethodscopeint;
		
		for(int i = 0; i < 2; i ++){
			System.out.println("i is a local aka block var");
		}
		
		
	//	System.out.println(floatInst);
	//	System.out.println(anothermethodscopeint);
		//i = 8; //WRONG
		
	}
	
	//methodscopeint = 10; //WRONG
//	anothermethodscopeint = 0;
	
}
