

public class Constructors {

	public static void main(String[] args) {
		MyClass wowClass = new MyClass();
		

	}
	
	public static class MyClass {
		
		int x, y;
		
		public MyClass(){
			x = 0;
			y = 0;
		}
		
		public MyClass(int x){
			this.x = x;
			y = 0;
		}
		
		public MyClass(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
