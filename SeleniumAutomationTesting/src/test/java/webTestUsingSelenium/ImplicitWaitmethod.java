package webTestUsingSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitmethod {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//implicit wait method
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.clear();
		username.sendKeys("Admin");
		
		

	}

}
