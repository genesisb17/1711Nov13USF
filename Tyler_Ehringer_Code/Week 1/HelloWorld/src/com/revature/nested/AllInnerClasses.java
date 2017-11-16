package com.revature.nested;

public class AllInnerClasses {
	
	class Instance{
		void message() {
			System.out.println("in instance class");
		}
	}
	
	static class StaticClass{
		void message() {
			System.out.println("static inner class");
		}
	}
	
	public static void main(String[] args) {
		
		StaticClass iObject = new StaticClass() {
			@Override
			void message() {
				System.out.println("anon class");
			}
		};
		
		class Local{
			void message() {
				System.out.println("in method inner class");
			}
		}
	}

}
