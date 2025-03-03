package TestNG_Listners;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScenarioForListners {

	
	WebDriver driver;
	
	@BeforeClass
	void setup() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
	}
	@Test(priority=1)
	void checkURL() {
		
	  String act_url = driver.getCurrentUrl();
	  Assert.assertEquals(act_url, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test(priority=2)
	void checkTitle() {
		
		String act_Title = driver.getTitle();
		Assert.assertEquals(act_Title, "Orange");
	}
	
	@Test(priority=3, dependsOnMethods = {"checkTitle"})
	void checkLoginButton() {
		
	 boolean status = false;
	 status = driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed();
	 Assert.assertTrue(status);
		
	}
	
	@AfterClass
	void teardown() {
		driver.quit();
	}
	
}
	
	