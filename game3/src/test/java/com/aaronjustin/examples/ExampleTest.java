package com.aaronjustin.examples;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ExampleTest {
	private Example ex = new Example();

	@Test
	public void testAdd_1_2() {
		// arrange
		int a = 1;
		int b = 2;
		
		// act
		int c = ex.add(a, b);
		
		// assert
		assertEquals(3, c);
	}

	@Test
	public void test2() {
		// arrange
		int a = 2;
		int b = 2;
		
		// act
		int c = ex.add(a, b);
		
		// assert
		assertEquals(4, c);
	}
	
	@Test
	public void testSubtract_5_1() {
		// arrange
		int a = 5;
		int b = 1;
		
		// act
		int c = ex.subtract(a, b);
		
		// assert
		assertEquals(4, c);		
	}
}
