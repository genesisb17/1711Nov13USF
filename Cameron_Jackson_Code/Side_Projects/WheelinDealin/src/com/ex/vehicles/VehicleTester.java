package com.ex.vehicles;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VehicleTester {
	Vehicle v1;
	Vehicle v2;
	Car c;
	Vehicle toCar;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		v1 = new Vehicle();
		v2 = new Vehicle("2", 5);
		c = new Car("2", 5);
		toCar = new Car("2", 5);
	}

	@After
	public void tearDown() throws Exception {
		v1 = null;
		v2 = null;
		c = null;
	}

	/*
	 * Vehicle Tests
	 */
	@Test
	public void testVehicleDefaultSerial() {
		String expected = "1";
		String actual = v1.serialNumber();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testVehicleDefaultPassCap() {
		int expected = 0;
		int actual = v1.passengerCapacity();
		assertEquals(expected, actual);
	}
	
	@Test 
	public void testVehicleDefaultLoadCap() {
		double expected = 0;
		double actual = v1.loadCapacity();
		assertEquals(expected, actual, 0);
	}
	
	@Test
	public void testVehicleCustomSerial() {
		String expected = "2";
		String actual = v2.serialNumber();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testVehicleCustomPassCap() {
		int expected = 5;
		int actual = v2.passengerCapacity();
		assertEquals(expected, actual);
	}
	
	@Test 
	public void testVehicleCustomLoadCap() {
		double expected = 0;
		double actual = v2.loadCapacity();
		assertEquals(expected, actual, 0);
	}
	
	@Test
	public void testVehicleDefaultSnDecode() {
		VehicleType expected = VehicleType.VEHICLE;
		VehicleType actual = Vehicle.SnDecode(v1.serialNumber());
		assertEquals(expected, actual);
	}
	
	@Test 
	public void testVehicleCustomSnDecode() {
		VehicleType expected = VehicleType.CAR;
		VehicleType actual = Vehicle.SnDecode(v2.serialNumber());
		assertEquals(expected, actual);
	}
	
	@Test
	public void testVehicleShortName() {
		String expected = "UNK";
		String actual = v1.shortName();
		assertEquals(expected, actual);
	}
	
	/*
	 * Test Car
	 */
	@Test
	public void testCarShortName() {
		String expected = "CAR";
		String actual = c.shortName();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCarPassCap() {
		int expected = 5;
		int actual = c.passengerCapacity();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCarLoadCap() {
		double expected = 0;
		double actual = c.loadCapacity();
		assertEquals(expected, actual, 0);
	}
	
	@Test
	public void testCarSnDecode() {
		VehicleType expected = VehicleType.CAR;
		VehicleType actual = Vehicle.SnDecode(c.serialNumber());
		assertEquals(expected, actual);
	}
	
	/*
	 * Test Vehicle initialized to Car
	 */
	@Test
	public void testToCarShortName() {
		String expected = "CAR";
		String actual = toCar.shortName();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testToCarPassCap() {
		int expected = 5;
		int actual = toCar.passengerCapacity();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testToCarLoadCap() {
		double expected = 0;
		double actual = toCar.loadCapacity();
		assertEquals(expected, actual, 0);
	}
	
	@Test
	public void testToCarSnDecode() {
		VehicleType expected = VehicleType.CAR;
		VehicleType actual = Vehicle.SnDecode(c.serialNumber());
		assertEquals(expected, actual);
	}
}
