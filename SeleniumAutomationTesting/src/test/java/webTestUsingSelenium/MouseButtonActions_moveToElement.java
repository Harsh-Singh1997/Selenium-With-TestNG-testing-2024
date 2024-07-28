package webTestUsingSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseButtonActions_moveToElement {

	public static void main(String[] args) throws InterruptedException {
		
		
        WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		
		//Hover to mobile option and click then hover on Audio option
		WebElement Mobiles = driver.findElement(By.xpath("//a[normalize-space()='Mobiles']"));
		
		Actions mouse1 = new Actions(driver);
		mouse1.moveToElement(Mobiles).click().perform();
		mouse1.moveToElement(driver.findElement(By.xpath("//a[contains(@aria-label,'Audio')]//span[@class='nav-a-content']"))).perform();
		Thread.sleep(5000);
		driver.quit();
	}

}
