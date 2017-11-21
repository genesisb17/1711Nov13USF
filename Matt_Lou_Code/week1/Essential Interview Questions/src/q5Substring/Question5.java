package q5Substring;

public class Question5 {

	public static void main(String[] args) {
		System.out.println(substring("hellomister", 7));

	}
	static String substring (String str, int idx) {
		String[] strArr = str.split("");
		String returnStr = "";
		for(int i = 0; i < idx - 1; i++) {
			returnStr += strArr[i];
		}
		return returnStr;
	}
}
