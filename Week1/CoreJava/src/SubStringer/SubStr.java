package SubStringer;

public class SubStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "Your boy came straight from the Bronx for this!";
		int sub = 7;
		String newest = subIt(test,sub);
		System.out.println(newest);
		
	}
	static String subIt(String sentence, int index) {
		char[] newSent = sentence.toCharArray();
		char[] postSub = new char[index+1];
		for(int x=0; x<index; x++) {
			postSub[x] = newSent[x];
		}
		String finalSent = new String(postSub);
		return finalSent;

	}
	

}
