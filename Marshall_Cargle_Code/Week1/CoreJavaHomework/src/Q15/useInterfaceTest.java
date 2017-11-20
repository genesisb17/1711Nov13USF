package Q15;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class useInterfaceTest {

	useInterface u;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		u=new useInterface();
	}

	@AfterEach
	void tearDown() throws Exception {
		u=null;
	}

	@Test
	void testAddition() {
		assertEquals(10, u.addition(5,5));
	}
	
	@Test
	void testSubtraction() {
		assertEquals(0, u.subtraction(5, 5));
	}
	
	@Test
	void testMultiplication() {
		assertEquals(25, u.multiplication(5, 5));
	}
	
	@Test
	void testDivision() {
		assertEquals(1, u.division(5, 5));
	}

}
