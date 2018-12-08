package com.aaronjustin.examples;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ExampleTest {
	private Example ex = new Example();

	@Test
	public void test1() {
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
		int a = 1;
		int b = 2;
		
		// act
		int c = ex.add(a, b);
		
		// assert
		assertEquals(4, c);
	}
}
