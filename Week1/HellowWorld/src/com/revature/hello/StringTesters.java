package com.revature.hello;

public class StringTesters {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		String name = "Felix Abreu";
		String herName = " Genesis Bonds";
		String theirName = makeLongerSentence(name, herName);
		String sister = "Nichole Abreu";
		String newSister = newName(sister,8);
		int hashValue = returnHash(name);
		int random = 3;
		String lastOne = "u";
		boolean lastCheck = checkFinish(name, lastOne);
		int codePoint = returnCodePoint(name, random);
		System.out.println(hashValue);
		System.out.println(codePoint);
		System.out.println(theirName);
		System.out.println(lastCheck);
		System.out.println(newSister);
	}
	static int returnHash(String trial) {
		return trial.hashCode();
	}
	
	static int returnCodePoint(String myGuy,int x) {
		return myGuy.codePointAt(x);
	}
	static String makeLongerSentence(String myGuy, String myGyal) {
		return myGuy.concat(myGyal);
	}
	static boolean checkFinish(String myGuy, String lastLetter) {
		return myGuy.endsWith(lastLetter);
	}
	static String newName(String getIt, int start) {
		return getIt.substring(start);
	}

}
