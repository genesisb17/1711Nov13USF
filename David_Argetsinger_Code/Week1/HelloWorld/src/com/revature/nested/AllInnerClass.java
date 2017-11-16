package com.revature.nested;

public class AllInnerClass {
	class Instance{
		void message (){
			System.out.println("inner class, isntance scope  ");
		}
	}
	static class StaticClass{
		void message (){
			System.out.println("Static inner class ");
		}
	
	}
	public static void main(String[] args) {
		StaticClass anonInstance = new StaticClass(){
			@Override
			void message (){
				System.out.println("using anon class to override method of static inner class ");
			}
		};
		class Local{
			void message (){
				System.out.println("in method inner class ");
			}
		}
	}

}
