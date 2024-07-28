package webTestUsingSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class HandellingAlerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
	
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Thread.sleep(3000);
		
		//click on OK button in alert popup 1
		Alert Alert1 = driver.switchTo().alert();
		System.out.println("Alert Message: "+Alert1.getText());
		Alert1.accept();
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Thread.sleep(3000);
		
		//click on Cancle button in alert popup 2
		Alert Alert2 = driver.switchTo().alert();
		System.out.println("Alert Message: "+Alert2.getText());
		//Alert2.accept(); // to click on OK button on alert2
		Alert2.dismiss(); // to click on Cancle button on alert2
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(3000);
		
		//Add text in alert prompt 3
		Alert Alert3 = driver.switchTo().alert();
		Alert3.sendKeys("Alert prompt");
		Alert3.accept();

	}

}
