package Day4;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class lab111617test {
	lab111617 c;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		 c = new lab111617();
	}

	@After
	public void tearDown() throws Exception {
		c=null;
	}

	@Test
	public void testiseven() {
		//fail("Not yet implemented");
		System.out.println("in test iseven method");
		boolean expected = true;
		boolean actual = c.iseven(10);
		assertEquals(expected,actual);
	}
}
