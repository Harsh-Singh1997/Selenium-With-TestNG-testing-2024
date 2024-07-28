package TestNG_SeleniumTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginAppUsingTestNG {
	
	//Launch Browser in chrome
	WebDriver driver = new ChromeDriver();

    @Test(priority=1)
	void OpenApp() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		//Open URL
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();	
		
	}
	
	@Test(priority=2)
	void LogininApp() {
		
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.clear();
		username.sendKeys("Admin");
		
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.clear();
		password.sendKeys("admin123");
		
		WebElement loginbutton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		loginbutton.click();
		
		
	}
	
	@Test(priority=3)
	void HomePageTitleValidation() {
		
		String HomePgTitle=driver.getTitle();
		
		String ExpTitle = "OrangeHRM";
		
		if(HomePgTitle.equals(ExpTitle)) {
			System.out.println("Test case: PASS ===>" + "Title: " + HomePgTitle); 
		} else {
			
			System.out.println("Test case: FAIL ===>");
			System.out.println("Actual Title: " + HomePgTitle);
			System.out.println("Expected Title:" + ExpTitle);
			 
		}
	}
	
	@Test(priority=4)
	void LogOutfromApp() {
		driver.quit();
		
	}

}
