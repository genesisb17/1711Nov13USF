package q11data;

public class Data {
	
	public float getF1() {
		return f1;
	}

	public void setF1(float f1) {
		this.f1 = f1;
	}

	public float getF2() {
		return f2;
	}

	public void setF2(float f2) {
		this.f2 = f2;
	}

	private float f1, f2;
	
	public Data() {
		f1 = (float)Math.PI;
		f2 = (float)Math.E;
	}

}
