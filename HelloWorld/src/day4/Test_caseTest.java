package day4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import day4.Even_checker;

public class Test_caseTest 
{
	Even_checker e;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	System.out.println("BEfore Class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	System.out.println("AFter class");
	}
	@Before
	public void setUp() throws Exception {
	e = new Even_checker();
	}

	@After
	public void tearDown() throws Exception {
	e =null;
		System.out.println("after method");
	}

	@Test
	public void test() {
		System.out.println(e.test(12));
		System.out.println(e.a());
		//ArrayList<Integer>e.a();
		System.out.println(e.minm(5, 7));
	}

}
