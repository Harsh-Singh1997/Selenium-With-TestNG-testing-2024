package webTestUsingSelenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetmethodsSelenium {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(5000);
		
		System.out.println(driver.getTitle()); // Will get title of web page open
		
		System.out.println(driver.getCurrentUrl()); // Will get current url

		//System.out.println(driver.getPageSource()); //get page source for web page
		
		//String windowid = driver.getWindowHandle();
		//System.out.println("Window ID: " + windowid);
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set<String> windowids = driver.getWindowHandles();
		System.out.println(windowids);
		
		
	}

}
