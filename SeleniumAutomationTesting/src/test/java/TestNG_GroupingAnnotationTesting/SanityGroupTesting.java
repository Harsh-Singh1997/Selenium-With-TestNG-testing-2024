package TestNG_GroupingAnnotationTesting;

import org.testng.annotations.Test;

public class SanityGroupTesting {
	
	@Test(priority=1, groups = {"sanity"})
	void OpenFacebookApp() {
		System.out.println("FACEBOOK APP OPEN");
	}
	
	@Test(priority=2, groups = {"sanity"})
	void OpenGoogleApp() {
		System.out.println("GOOGLE APP OPEN");
	}
	
	@Test(priority=3, groups = {"sanity"})
	void OpenMicroSoftApp() {
		System.out.println("MICROSOFT APP OPEN");
	}


}
