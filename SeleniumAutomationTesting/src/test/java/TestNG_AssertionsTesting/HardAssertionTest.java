package TestNG_AssertionsTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
 Hard Assertions: Hard Assertion is a type of assertion where if a assertion fails, the test will fail and will skip all the steps after assertions.
 */

public class HardAssertionTest {
	
	@Test
	void hardassertion() {
		
		//Hard Assertion
		Assert.assertEquals("LinkedIn", "LinkedIn");
		System.out.println("TEST 1 Executed..........");
		Assert.assertEquals("Googlemail", "Googlemail");
		System.out.println("TEST 2 Executed..........");
		Assert.assertEquals("Android", "Apple");
		System.out.println("TEST 3 Executed.........."); //This test will not execute in due to above assertion fail
		
	}

}
