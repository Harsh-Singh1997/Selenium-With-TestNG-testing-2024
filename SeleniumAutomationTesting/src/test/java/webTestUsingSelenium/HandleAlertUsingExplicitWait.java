package webTestUsingSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlertUsingExplicitWait {

	//Handling alert without using switchTo().Alert()
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10)); //explicit wait declaration
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Thread.sleep(3000);
		
		Alert Alert1 = mywait.until(ExpectedConditions.alertIsPresent());
		
		System.out.println("Alert Message: "+Alert1.getText());
		Alert1.accept();
		
		driver.close();

	}

}
