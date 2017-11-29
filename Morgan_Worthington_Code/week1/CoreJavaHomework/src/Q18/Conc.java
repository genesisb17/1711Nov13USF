package Q18;

public class Conc extends Abs {

	@Override
	boolean checkUpper(String str) {
		boolean check=false;
		for(int i=0;i<str.length();i++) {
			if(Character.isUpperCase(str.charAt(i))) {
				check=true;
			}
		}
		return check;
	}

	@Override
	String toUpper(String str) {
		return str.toUpperCase();
	}

	@Override
	int convertAdd10(String str) {
		int num=Integer.parseInt(str);
		return num + 10;
	}

}
