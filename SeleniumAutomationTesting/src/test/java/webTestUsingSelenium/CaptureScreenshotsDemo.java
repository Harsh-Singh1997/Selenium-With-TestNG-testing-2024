package webTestUsingSelenium;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshotsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//taking screenshot
		TakesScreenshot ts= (TakesScreenshot) driver; 
		
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		
		File targetfile = new File(System.getProperty("user.dir") + "\\ScreenShots\\AmazonHomePage.png");
		
		sourcefile.renameTo(targetfile);
		
		
		//Capture certain section on webpage using Webelement
		
		WebElement primeDaySection = driver.findElement(By.xpath("//div[contains(@data-card-metrics-id,'fluid-quad-image-label-v2_desktop-gateway-btf_10')]"));
		Thread.sleep(5000);
		
		File primesourcefile = primeDaySection.getScreenshotAs(OutputType.FILE);
		Thread.sleep(5000);
		
		File primeOutputFile = new File(System.getProperty("user.dir") + "\\\\ScreenShots\\\\AmazonPrimeDay.png");
		
		primesourcefile.renameTo(primeOutputFile);		
		
		driver.quit();

	}

}
