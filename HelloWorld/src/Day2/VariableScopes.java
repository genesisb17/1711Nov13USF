package Day2;

public class VariableScopes {
//instance variable have default values
	boolean boolInst;
	byte byteInst;
	short shortInst;
	int intInst;
	float floatINst;
	double doubleInst;
	char charInst;
	Object objInst;
	
	static int count;
	static boolean isActive;
	static
	{
		System.out.println("I can't believe this works");
	}
	public static void main(String args[])
	{
		
		/*System.out.println("int istance var default = "+intInst);
		System.out.println("int static var default = "+counter);
	*/}
	void test(int methodscopeint)
	{
		methodscopeint=0;
	}
}
