package webTestUsingSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseButtonActions_RightClick {

	public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://swisnl.github.io/jQuery-contextMenu/3.x/demo.html");
		driver.manage().window().maximize();
		
		
		
		Actions mouse = new Actions(driver);
		mouse.contextClick(driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"))).perform();
		Thread.sleep(2000);
		mouse.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Copy']"))).click().perform();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.quit();
	}

}
