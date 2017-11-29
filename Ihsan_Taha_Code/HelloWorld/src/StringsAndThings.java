
public class StringsAndThings {
	public static void main(String[] args)
	{
		String str = "Hello";
		StringBuffer strBuff = new StringBuffer("Hello");
		StringBuilder strBuild = new StringBuilder("Hello");
		
		str.concat(" world");
		strBuff.append(" buff");
		strBuff.append(" build");
		
		System.out.println(str + " " + strBuff + " " + strBuild);
	}
}
