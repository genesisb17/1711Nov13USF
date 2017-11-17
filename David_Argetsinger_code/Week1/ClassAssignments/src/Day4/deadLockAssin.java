package Day4;

public class deadLockAssin {
	public static String Resource1=new String();
	public static String Resource2=new String();
	//resources used that will be requested by both threads in order to deadlock 
	
	private static class Thread1 extends Thread{
		public void run(){
			synchronized(Resource1){
				System.out.println("resource 1 is held by thread 1");
				try{Thread.sleep(13);}
				catch(InterruptedException e)
				{e.printStackTrace();}
				System.out.println("thread 1 LOCKED waiting for 2");
				synchronized(Resource2){
					System.out.println("resource 1 & 2  is held by thread 1");
				}
			}
		}
	}
	
	private static class Thread2 extends Thread{
		public void run(){
			synchronized(Resource2){
				System.out.println("resource 2 is held by thread 2");
				try{Thread.sleep(13);}
				catch(InterruptedException e)
				{e.printStackTrace();}
				System.out.println("thread 2 LOCKED waiting for 1");
				synchronized(Resource1){
					System.out.println("resource 1 & 2  is held by thread 2");
				}
			}
		}
	}
	public static void main(String[] args) {
		//deadlocks are situations where two or more threads are blocked
		//waiting for eachother (usually on a resource)
	      Thread1 T1 = new Thread1();
	      Thread2 T2 = new Thread2();
	      T1.start();
	      T2.start();

	}

}
