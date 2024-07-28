package webTestUsingSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandellingCheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//input[@id='male']")).click();
		//select single checkbox
		//driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		//select all checkboxes
		/*
		 List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		 
		 for(WebElement checkbox:checkboxes) {
			 checkbox.click();
		 }
		 */
		
		//select last 3 checkboxes
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
		for(int i = 4;i<checkboxes.size();i++) {
			checkboxes.get(i).click();
		}
		
		Thread.sleep(5000);
		
		//unselect checkboxes that are already selected
		
		for(WebElement checkbox:checkboxes) {
			if(checkbox.isSelected()) {
				checkbox.click();
			}
		}
		
		
		 

	}

}
