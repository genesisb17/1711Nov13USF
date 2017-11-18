package com.revature.corejavahw;

public class Operations implements OperationsInterface {

	static int x = 10;
	static int y = 2;
	
	public static void main(String[] args) {
		Operations O = new Operations();
		int result = O.add(x, y);
		System.out.println(result);
		int result1 = O.sub(x, y);
		System.out.println(result1);
		int result2 = O.mul(x, y);
		System.out.println(result2);
		int result3 = O.div(x, y);
		System.out.println(result3);
	}

	@Override
	public int add(int x, int y) {
		return x + y;
	}

	@Override
	public int sub(int x, int y) {
		return x - y;
	}

	@Override
	public int mul(int x, int y) {
		return x * y;
	}

	@Override
	public int div(int x, int y) {
		return x / y;
	}

}
