import java.util.StringTokenizer;

public class practiceStringBuild {
	
	
	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("example");
		str.replace(0, 2, "yo");
		System.out.println(str);
		str.append(" comes after");
		System.out.println(str);
		str.deleteCharAt(6);
		System.out.println(str);
		
		System.out.println("------------------- \n");
		
		StringTokenizer tok = new StringTokenizer("food:waiting:hungry:laptop:monitor", ":");
		while(tok.hasMoreTokens()) {
			System.out.println(tok.nextToken());
		}
		
		System.out.println("------------------ \n");
		
		String num1 = "20";
		String num2 = "50";
		
		System.out.println(addTwo(num1, num2));;
		
		Runtime run = Runtime.getRuntime();
		run.gc();
		System.out.println(run.availableProcessors());
		System.out.println(run.totalMemory());
		
	}
	public static int addTwo(String numb1, String numb2) {
		System.gc();
		return Integer.parseInt(numb1) + Integer.parseInt(numb2);
		
	}

}
