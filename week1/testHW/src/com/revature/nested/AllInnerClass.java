package com.revature.nested;

public class AllInnerClass {

	class Instance{
		void message() {
			System.out.println("inner class, instance scope");
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
				System.out.println("using anon class to override" + "method of instance class");
			}
		};
		
		class Local{
			void message() {
				System.out.println("in method inner class.");
			}
		}

	}

}
