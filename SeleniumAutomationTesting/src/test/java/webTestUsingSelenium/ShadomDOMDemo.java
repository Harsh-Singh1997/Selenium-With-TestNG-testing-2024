package webTestUsingSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadomDOMDemo {

	public static void main(String[] args) throws InterruptedException {
WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://books-pwakit.appspot.com/");
		
		driver.manage().window().maximize();
		
		//Element inside single shadow DOM
		//Shadow DOMS cannot be find using xpaths.
		
		SearchContext shadow=driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot(); //using CssSelector to find shadow DOM
		Thread.sleep(2000);
		shadow.findElement(By.cssSelector("#input")).sendKeys("Welcome");		
		
		

	}

}
