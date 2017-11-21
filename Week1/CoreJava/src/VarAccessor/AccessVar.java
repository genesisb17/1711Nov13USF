package VarAccessor;

import VarCreator.CreateVar;

public class AccessVar extends CreateVar  {

	public static void main(String[] args) {
		/*
		 * This class is used to illustrate what you need to do in order 
		 * to access variables from another class that is in another package.
		 * 1) import package containing class with variables you want to access
		 * 			import PackageName.ClassName
		 * 2) extend the class that contains the variables you would like to access 
		 * 			public class CurrentClass extends ClassWithVarToBeAccessed
		 * ***** YOU MUST INITIALIZE THE VARIALES AS PUBLIC STATIC
		 * 				public static varType varName;
		 */
		
		System.out.println("My birth month that is initialized in the CreateVar class, which is extended in this class is "
				+ birthMonth);
		System.out.println("My birth day that is initialized in the CreateVar class, which is extended in this class is "
				+ birthDay);
	}

}
