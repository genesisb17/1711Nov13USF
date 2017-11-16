package day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JavaLabTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCheckEven() {
		JavaLab jl = new JavaLab();
		assertEquals(true, jl.checkEven(0));
		assertEquals(false, jl.checkEven(1));
		assertEquals(true, jl.checkEven(2));
		assertEquals(false, jl.checkEven(777));
		assertEquals(true, jl.checkEven(1088));
		
	}

}
