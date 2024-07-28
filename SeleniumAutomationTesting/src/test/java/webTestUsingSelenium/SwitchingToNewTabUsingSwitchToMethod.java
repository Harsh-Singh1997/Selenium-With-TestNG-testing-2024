package webTestUsingSelenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingToNewTabUsingSwitchToMethod {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		//Switching to new tab using newwindows() Method(Avaliable from Selenium 4)
		
		//driver.switchTo().newWindow(WindowType.TAB); //This will open and switch to new tab
		driver.switchTo().newWindow(WindowType.WINDOW); //This will open page in new window 
		
		
		driver.get("https://www.orangehrm.com/");
		//driver.manage().window().minimize(); to minimize the window 

		driver.quit();
	}

}
