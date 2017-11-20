package q11;

import q11data.Data;

public class AccessAcrossPackages {
	
	public static void main(String[] args) {
		Data d = new Data();
		System.out.println(d.getF1());
		System.out.println(d.getF2());
	}
}
