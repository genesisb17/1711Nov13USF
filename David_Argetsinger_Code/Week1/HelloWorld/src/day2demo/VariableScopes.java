package day2demo;

public class VariableScopes {
	/* instance variales have default values 
	 *  public protected package private  access levels / modifiers 
	 *  variable scopes :  instance, static/class method local/block 
	 *  // any member that is static belongs to class and not objects of the class 
	 *  //instance is full instance of variable scope 
	 *  if they bleong to class and not instance they need to HAVE an instance of them to work 
	 *  cannot access instance members from static members 
	 *  methos is within functions alone 
	 *  instance and class/static are given default values if not init!! 
	 *  declaire initialize and instantiate 
	 *  declare = assign
	 *  instansiate = making an instance 
	 *  initailize = giving value 
	 */
	boolean boolInst;
	byte byteInst;
	short shortInst;
	int intInst;
	long longInst;
	float floatInst;
	double doubleInst;
	char charInst;
	Object ojbInst;
	
	// class vars aka static 
		static int counter;
		static boolean isActive;
		
	public static void main(String[] args) 
	{
		//System.out.println(" int instace var default ="+ intInst);
		System.out.println(" int static var defaut = " + counter);
	}
	void test(int methodscopeint){
	methodscopeint = 0;
	for (int i = 0; i <10; i++)
	System.out.println(" is is local aka block var  ");
	}
	}
}
