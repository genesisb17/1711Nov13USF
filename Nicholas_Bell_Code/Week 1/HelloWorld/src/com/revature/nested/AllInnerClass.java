package com.revature.nested;

public class AllInnerClass {

	class Instance{
		void message() {
			System.out.println("Inner class, instance stops");
		}
	}
	
	static class StaticClass{
		void message() {
			System.out.println("static inner class");
		}
	}
	
	public static void main(String[] args) {
		StaticClass anonClass = new StaticClass() {
			@Override
			void message() {
				System.out.println("using anon clas to override "
						+ "method of static inner class");
			}
			
		};
		
		
		class Local{
			void message() {
				System.out.println("in method inner class");
			}
		}
	}
	
}
