package TestNG_GroupingAnnotationTesting;

import org.testng.annotations.Test;

public class RegressionGroupTesting {
	
	@Test(priority=1, groups = {"regression"})
	void LoginFacebookApp() {
		System.out.println("Login in FACEBOOK: Pass");
	}
	
	@Test(priority=2, groups = {"regression"})
	void LoginGoogleApp() {
		System.out.println("Login in GOOGLE: Pass");
	}
	
	@Test(priority=3, groups = {"regression"})
	void LoginMicroSoftApp() {
		System.out.println("Login in MICROSOFT 365: Pass");
	}

}
