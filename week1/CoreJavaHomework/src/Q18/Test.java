package Q18;

public class Test {
	
	public static void main(String[] args) {
		Abs obj=new Conc();
		String str="nEw TwItTeR mEmE";
		String num="144";
		
		Boolean check=obj.checkUpper(str);
		String upper=obj.toUpper(str);
		int add10=obj.convertAdd10(num);
		
		System.out.println("Method 1: "+check);
		System.out.println("Method 2: "+upper);
		System.out.println("Method 3: "+add10);
	}

}
