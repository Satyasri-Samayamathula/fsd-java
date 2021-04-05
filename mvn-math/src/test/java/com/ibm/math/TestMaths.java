package com.ibm.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestMaths {
	public static Maths maths;
	
	@BeforeAll
	public static void steup() {
		maths=new Maths();
	}
	
	@Test
	public void testAdd() {
		assertEquals(10,maths.sum(5, 5));
	}
	@Test
	public void testSub() {
		assertEquals(10,maths.sub(20, 10));
	}
	@Test
	public void testSquare() {
		assertEquals(25,maths.square(5));
	}
	
	@Test
	public void testDiv() {
		assertEquals(2,maths.div(4,2));
	}
	
	@Test
	public void testsq() {
		assertNotEquals(5,maths.square(2));
	}
	@Test
	public void testZeroDiv() {
		//assertEquals(10,maths.sum(5, 5));
		assertThrows(ArithmeticException.class,()->maths.div(2, 0));
	}
	
	
}