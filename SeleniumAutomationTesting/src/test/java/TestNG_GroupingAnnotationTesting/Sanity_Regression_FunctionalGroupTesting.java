package TestNG_GroupingAnnotationTesting;

import org.testng.annotations.Test;

public class Sanity_Regression_FunctionalGroupTesting {
	
	@Test(priority=1, groups = {"sanity","regression","functional"})
	void PaymentInFacebookApp() {
		System.out.println("Payment in FACEBOOK: Pass");
	}
	
	@Test(priority=2, groups = {"sanity","regression","functional"})
	void PaymentInGoogleApp() {
		System.out.println("Payment in GOOGLE: Pass");
	}
	
	@Test(priority=3, groups = {"sanity","regression","functional"})
	void PaymentInMicroSoftApp() {
		System.out.println("Payment in MICROSOFT: Pass");
	}

}
