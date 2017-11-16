package Day4Lab;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EvenNumberTest {

	EvenNumber n;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		n = new EvenNumber();
	}

	@After
	public void tearDown() throws Exception {
		n=null;
	}

	@Test
	public void testEven() {
		System.out.println("Please enter in an Integer:");
		Scanner scanIn = new Scanner(System.in);
		int actual=n.even(scanIn.nextInt());
		if(actual==0)
			System.out.println("Even");
		else if(actual==1)
			System.out.println("odd");
		else
			fail();
	}
}
