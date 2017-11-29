package day3demo;

public class StringsandThings {

	public static void main(String[] args){
		String str="hello";
		StringBuffer buff = new StringBuffer("hello");
		StringBuilder build= new StringBuilder("hello");
		
		str.concat(" world");
		buff.append(" buff");
		build.append(" world");
		
		System.out.println(str + " " + buff + " " + build);
		
		System.out.println(buff.reverse());
		
		testBuild(build.toString());
		
		//assignment to make a StringBuilder and use 3 methods
		StringBuilder strB=new StringBuilder("test");
		System.out.println(strB);
		
		//add to the end of strB
		strB.append("123");
		System.out.println(strB);
		
		//deleting a substring from the middle
		strB.delete(2, 4);
		System.out.println(strB);
		
		//replacing a substring with another string
		strB.replace(0,3,"REPLACED");
		System.out.println(strB);
		
	}
	
	static String testBuild(String sb){
		return sb;
	}
}
