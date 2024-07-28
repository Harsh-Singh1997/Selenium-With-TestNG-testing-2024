package webTestUsingSelenium;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInZoomOutDemoUsingJavaScript {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://snapdeal.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Zoom in to 110% of page
		
		js.executeScript("document.body.style.zoom = '110%'");
		
		Thread.sleep(2500);
		
		//Zoom out to 50% of page
		
		js.executeScript("document.body.style.zoom = '50%'");
		
		Thread.sleep(2500);
		
		//Zoom out to 20% of page
		
		js.executeScript("document.body.style.zoom = '20%'");
		
		Thread.sleep(2500);
		
		//Zoom in to 80% of page
		
		js.executeScript("document.body.style.zoom = '80%'");
		
		Thread.sleep(4000);
		
		driver.close();

	}

}
