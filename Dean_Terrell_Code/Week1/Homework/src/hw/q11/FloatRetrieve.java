package hw.q11;

import hw.q7.*;

public class FloatRetrieve {

	public static void main(String[] args) {
		Employee e = new Employee("Dave", "Math", 50);
		
		System.out.printf("Floats from employee class: %.0f and %.0f", e.exampleFloat, e.exampleFloat2);
		
	}

}
