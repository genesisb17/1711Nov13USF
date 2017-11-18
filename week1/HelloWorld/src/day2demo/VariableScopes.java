package day2demo;

public class VariableScopes {

	
	//class vars aka static
	static int counter;
	static boolean isActive;
	
	/*
	 * instance variables have default values
	 */
	
	boolean boolInst;
	byte byteInst;
	short shortInst;
	static int intInst;
	long longInst;
	float floatInst;
	double doubleInst;
	char charInst;
	Object objInst;
	
	public static void main(String[] args){
		
		System.out.println("int instance var default = "+ intInst);
		System.out.println("int static var default = "+ counter);
	}
	
	void test(int methodscopeint){
		methodscopeint=0;

		for(int i=0; i<10;i++){
			System.out.println("i is a local aka block var");
		}
		System.out.println(floatInst);
		//System.out.println(anothermethodscopeint);
		
		
		//i=8; //WRONG
	}
}
