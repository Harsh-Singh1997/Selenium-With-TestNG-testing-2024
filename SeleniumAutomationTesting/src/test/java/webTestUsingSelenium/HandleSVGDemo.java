package webTestUsingSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleSVGDemo {

	public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']"))).sendKeys("Admin");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']"))).sendKeys("admin123");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Login']"))).click();
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='oxd-main-menu-item active']//*[name()='svg']"))).getText();
		
		

	}

}
