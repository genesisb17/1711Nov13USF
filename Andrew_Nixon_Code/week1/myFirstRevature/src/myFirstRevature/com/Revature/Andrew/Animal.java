package myFirstRevature.com.Revature.Andrew;

public abstract class Animal implements Livable {

	@Override
	public int reproduce(int parties) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void consume(String... substance) {

		System.out.println("All animals eat" + substance[2]);
		System.out.println("All animals breathe" + substance[0]);
	}

	@Override
	public abstract int perish(double expirationDate);

	@Override
	public abstract String locomotion(String move);
	public abstract void speak(String sound);

}
