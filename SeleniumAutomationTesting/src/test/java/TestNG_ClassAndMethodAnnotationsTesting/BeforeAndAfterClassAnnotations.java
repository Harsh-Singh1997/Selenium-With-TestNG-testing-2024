package TestNG_ClassAndMethodAnnotationsTesting;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BeforeAndAfterClassAnnotations {
		
		@BeforeClass
		void LoginInApp() {
			
			System.out.println("Before Class: This is Login.......");
		}
		
		@Test
		void SearchInApp() {
			
			System.out.println("Test 1: This is search test in App........");
		}
		
		@Test
		void OpenLinkInApp() {
			
			System.out.println("Test 2: This is opening link in App test.......");
		}
		
		@AfterClass
		void LogoutFromApp() {
			
			System.out.println("After Class: This is to logout from app........");
		}

}
