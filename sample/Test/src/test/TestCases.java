package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class TestCases {

	@Test
	void test1() {
		String input = "Hello World!";
		String output = com.Test.vowelOnly(input);
		String expected = "eoo";
		Assert.assertEquals(expected, output);
	}
	
	@Test
	void test1Fail() {
		String input = "Hello World!";
		String output = com.Test.vowelOnly(input);
		String expected = "eo";
		Assert.assertNotEquals(expected, output);
	}
	
	@Test
	void test2() {
		String input = "Udacity Courses";
		String output = com.Test.vowelOnly(input);
		String expected = "Uaioue";
		Assert.assertEquals(expected, output);
	}

}
