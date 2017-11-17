package day4Java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JavaLabTest {

	JaveLab c, s;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		c = new JaveLab();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		boolean expected = false;
		boolean actual = c.even(21);
		
		assertEquals(expected, actual);
		
		
	}

}
