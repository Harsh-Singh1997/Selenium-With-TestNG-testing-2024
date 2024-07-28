package webTestUsingSelenium;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerHandling2 {

	public static void main(String[] args) {
		
		
		String Day = new String("25");
		String Month = new String("October");
		String Year = new String("2025");
				
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(driver.findElement(By.id("frame-one796456169")));
		
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
		
		//Select Yeardropdown = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		//Yeardropdown.selectByVisibleText(Year);
}
	
}
