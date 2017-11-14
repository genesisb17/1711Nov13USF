import java.io.IOException;

public class Exceptions {
	public static void main(String[] args)
	{
		// Must be here for last line to print due to scope issues!
		int[] arr = new int[5];
		
		try
		{
			arr[0] = 1;
			arr[4] = 4;
			arr[5] = 5;
			System.out.println("passed exception");
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}catch(RuntimeException re)
		{
			re.printStackTrace();
		}finally
		{
			System.out.println(" passed exception man");
			try
			{
				exampleException(5);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		System.out.println("\n" + arr[3]);
		
	}
	
	static void exampleException(int num) throws IOException
	{
		System.out.println("We are in an example exception method");
	}
}
