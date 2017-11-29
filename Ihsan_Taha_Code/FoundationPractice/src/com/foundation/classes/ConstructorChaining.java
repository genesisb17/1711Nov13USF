package com.foundation.classes;

public class ConstructorChaining {

	// Generation 1900's
	static class GrandParent {
		private int generation;

		GrandParent() {
		}

		GrandParent(int generation) {
			this.generation = generation;
		}

		int getGeneration() {
			return generation;
		}

		void setGeneration(int generation) {
			this.generation = generation;
		}

		void breed() {
			System.out.println("Giving birth to generation " + generation);
		}
	}

	// Generation 1950's
	static class Parent extends GrandParent {
		String job;

		Parent() {
			super(50);
			job = "Clerk";
		}

		Parent(String job) {
			this.job = job;
			super.generation = 0;
		}
		
		int getGeneration() {
			return super.getGeneration();
		}

		void setGeneration(int generation) {
			super.setGeneration(generation);
		}

		void breed() {
			System.out.println("Giving birth to " + job);
		}
	}

	public static void main(String[] args) {
		GrandParent gParent = new Parent();	
		Parent p = (Parent)gParent;
		System.out.println(p.getGeneration());
	}

}
