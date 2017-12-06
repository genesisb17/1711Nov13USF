package com.revature.nested;

public class AllInnerClass {

	class Instance{
		void message() {
			System.out.println("innner class, instance scope");
		}
	}
	
	static class StaticClass{
		void message() {
			System.out.println("static innner class");
		}
	}
	
	public static void main(String[] args) {
		
		StaticClass anonClass = new StaticClass() {
			@Override
			void message() {
				System.out.println("using anon class to override");
			}
		};
		
		class Local{
			void message() {
				System.out.println("in method innner class");
			}
		}
		
		
		
	}

}
