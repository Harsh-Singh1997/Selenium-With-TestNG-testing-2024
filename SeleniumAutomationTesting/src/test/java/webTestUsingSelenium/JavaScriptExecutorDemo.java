package webTestUsingSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement firstName = driver.findElement(By.xpath("//input[@id='name']"));
		
		//Enter text using JavaSciptExecutor - Alternate of sendKeys()
		js.executeScript("arguments[0].setAttribute('value','John')", firstName);
		
		WebElement male = driver.findElement(By.xpath("//input[@id='male']"));
		
		//click checkbox using JavaSciptExecutor - Alternate of click()
		js.executeScript("arguments[0].click()", male);

	}

}
