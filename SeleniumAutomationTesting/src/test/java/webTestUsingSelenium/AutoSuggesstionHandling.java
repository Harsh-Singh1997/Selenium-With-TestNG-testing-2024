package webTestUsingSelenium;

import java.net.SocketException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggesstionHandling {

	public static void main(String[] args) throws InterruptedException, SocketException {

     WebDriver driver = new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("http://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		
		Thread.sleep(2000);
		List<WebElement> search = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
		
		for(WebElement op:search) {
			
			String s = op.getText();
			
			if(s.equals("selenium") || s.equals("Selenium")) {
				op.click();
				break;
			}
		}
		Thread.sleep(6000);
		driver.close();
      
	}

}
