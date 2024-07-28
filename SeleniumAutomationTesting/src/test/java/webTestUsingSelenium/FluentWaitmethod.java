package webTestUsingSelenium;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitmethod {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(30))
			       .pollingEvery(Duration.ofSeconds(5))
			       .ignoring(NoSuchElementException.class);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		WebElement username = mywait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.xpath("//input[@placeholder='Username']"));
		     }
		   });
		
		username.sendKeys("Admin");
		
		WebElement password = mywait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.xpath("//input[@placeholder='Password']"));
		     }
		   });
		password.sendKeys("admin123");
		
		WebElement loginbtn = mywait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		     }
		   });
		loginbtn.click();
		
		Thread.sleep(8000);
		
		driver.quit();
		

	}

}
