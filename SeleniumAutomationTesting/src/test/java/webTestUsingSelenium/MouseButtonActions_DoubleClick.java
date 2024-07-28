package webTestUsingSelenium;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseButtonActions_DoubleClick {
	
	public static void main(String[] args) throws InterruptedException {
		

        WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		
		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
		field1.clear();
		field1.sendKeys("My name is Harsh!!");
		
		Actions mouseb = new Actions(driver);
		mouseb.doubleClick(driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"))).perform();
		Thread.sleep(3000);
		
		WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));
		String exptext = field2.getAttribute("value");
		
		System.out.println("Value in field 2 is: " + exptext);
		
		driver.quit();
	}

}
