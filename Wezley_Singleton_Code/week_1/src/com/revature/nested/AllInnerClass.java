package com.revature.nested;

public class AllInnerClass {

	/*
	 *  Instance inner/nested class
	 */
	class Instance {
		void message() {
			System.out.println("in inner Instance class");
		}
	}
	
	/*
	 *  Static inner/nested class
	 */
	static class StaticClass {
		void message() {
			System.out.println("in inner StaticClass class method");
		}
	}
	
	public static void main(String[] args) {
		
		/*
		 *  Anonymous Inner Class example
		 *  
		 *  Note: you cannot create an anonymous inner class for a non-static member 
		 *  	  class of the superclass
		 *  
		 */
		StaticClass anonStatic = new StaticClass() {
			@Override
			void message() {
				System.out.println("using anon class to override method of Instance class");
			}
		};
		
		/*
		 *  Local inner/nested class
		 */
		class Local {
			
			void message() {
				System.out.println("in method of inner Local class");
			}
			
		}
		
	}
	
}
