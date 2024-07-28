package webTestUsingSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseButtonActions_DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		
		WebElement source1 = driver.findElement(By.xpath("//li//h5[contains(.,'High Tatras 2')]"));
		WebElement source2 = driver.findElement(By.xpath("//li//h5[contains(.,'High Tatras 3')]"));
		WebElement target = driver.findElement(By.xpath("//div[@id='trash']"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(source1, target).perform();
		Thread.sleep(3000);
		act.dragAndDrop(source2, target).perform();
		Thread.sleep(3000);
		
		driver.quit();

	}

}
