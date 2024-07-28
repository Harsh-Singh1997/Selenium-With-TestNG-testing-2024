package webTestUsingSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingIframes {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		//frame 1
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src=\"frame_1.html\"]")); //frame1 webelement
		driver.switchTo().frame(frame1); //switching to frame using webelement
		
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Frame1 INPUT");
		
		//switch to main page
		driver.switchTo().defaultContent(); //We need to switch back to main page before switching to next iframe
		
		//frame 2 
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src=\"frame_2.html\"]"));
		driver.switchTo().frame(frame2); // switching to next frame
		
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Frame2 INPUT");
		
		//switch to main page
		driver.switchTo().defaultContent(); //switching back to main page
		
		//frame 3
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src=\"frame_3.html\"]"));
		driver.switchTo().frame(frame3);
		
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Frame3 INPUT");
		
		//inside frame in frame 3
		driver.switchTo().frame(0); //Switching to inside frame using index method
		driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']")).click();
		driver.findElement(By.xpath("//div[@id='i22']//div[@class='uHMk6b fsHoPb']")).click();
		
		//switch to main page
		driver.switchTo().defaultContent();

	}

}
