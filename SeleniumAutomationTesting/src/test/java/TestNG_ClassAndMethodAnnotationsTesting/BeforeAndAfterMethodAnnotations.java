package TestNG_ClassAndMethodAnnotationsTesting;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAndAfterMethodAnnotations {
	
	@BeforeMethod
	void LoginInApp() {
		
		System.out.println("Before Method: This is Login.......");
	}
	
	@Test
	void SearchInApp() {
		
		System.out.println("Test 1: This is search test in App........");
	}
	
	@Test
	void OpenLinkInApp() {
		
		System.out.println("Test 2: This is opening link in App test.......");
	}
	
	@AfterMethod
	void LogoutFromApp() {
		
		System.out.println("After Method: This is to logout from app........");
	}

}
