package Q15;

public class useInterface implements MathInterface {

	@Override
	public int addition(int i, int j) {
		return i+j;
	}

	@Override
	public int subtraction(int i, int j) {
		return i-j;
	}

	@Override
	public int multiplication(int i, int j) {
		return i*j;
	}

	@Override
	public int division(int i, int j) {
		return i/j;
	}

}
