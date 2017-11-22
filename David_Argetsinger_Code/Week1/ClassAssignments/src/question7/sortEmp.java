package question7;

import java.util.Comparator;



public class sortEmp implements Comparator {

	@Override
	public int compare(Object arg0, Object arg1) {
		 if((((Employees)arg0).name.compareToIgnoreCase(((Employees)arg1).name))<1)
		 {
			 System.out.println("first employee has a name less than the second");
		 }
		 if((((Employees)arg0).name.compareToIgnoreCase(((Employees)arg1).name))>1)
		 {
			 System.out.println("first employee has a name more than the second");
		 }
		 if((((Employees)arg0).name.compareToIgnoreCase(((Employees)arg1).name))==0)
		 {
			 System.out.println("both employees have the same name");
		 }
		 if((((Employees)arg0).dept.compareToIgnoreCase(((Employees)arg1).dept))<1)
		 {
			 System.out.println("first employee has a department less than the second");
		 }
		 if((((Employees)arg0).dept.compareToIgnoreCase(((Employees)arg1).dept))>1)
		 {
			 System.out.println("first employee has a department more than the second");
		 }
		 if((((Employees)arg0).dept.compareToIgnoreCase(((Employees)arg1).dept))==0)
		 {
			 System.out.println("both employees have the same department");
		 }
		 if((((Employees)arg0).age > ((Employees)arg1).age))
		 {
			 System.out.println("First employeee is older");
		 }
		 if((((Employees)arg0).age < ((Employees)arg1).age))
		 {
			 System.out.println("Second employeee is older");
		 }
		 if((((Employees)arg0).age == ((Employees)arg1).age))
		 {
			 System.out.println("Both employees are the same age");
		 }
		return 0;
	}
	static class Employees {
		String name;
		String dept;
		int age;
		Employees(String n, String dep, int age)
		{
			name=n;
			dept=dep;
			this.age=age;
		}
		
	}
	
}
