package TestNG_BeforeAndAfterTestAnnotationsTesting;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class BeforeAndAfterTestAnnotationTest2 {
	
	@Test
	void Test1() {
		
		System.out.println("This is test 2........");
	}
	
	@AfterTest
	void Login() {
		
		System.out.println("This is After Test method..........");
	}

}
