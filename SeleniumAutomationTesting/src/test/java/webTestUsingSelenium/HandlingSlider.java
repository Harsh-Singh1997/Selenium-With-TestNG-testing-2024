package webTestUsingSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingSlider {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		WebElement min_Slider = driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));
		
		Point Curr_minsliderlocation = min_Slider.getLocation(); //provide the location of slider in x:y dimensions
		
		//Note: min_slider.getlocation().getX() will give only X axis location
		//Note: min_slider.getlocation().getY() will give only Y axis location
				
		System.out.println("Location of Minimun Slider(x:y) is: " + Curr_minsliderlocation); //(59:250)

		//Move the slider in x axis only(y will remain 0)
		act.dragAndDropBy(min_Slider, 101, 0).perform();
		Thread.sleep(3000);
		
		WebElement max_Slider = driver.findElement(By.xpath("//div[@class='price-range-block']//span[2]"));
		Point   Curr_maxsliderlocation = max_Slider.getLocation();
		
		System.out.println("Location of Maximum Slider(x:y) is: " + Curr_maxsliderlocation);
		
		act.dragAndDropBy(max_Slider, -101, 0).perform();
		Thread.sleep(3000);
		
		Point new_minsliderlocation = min_Slider.getLocation();
		Point new_maxsliderlocation = max_Slider.getLocation();
		
		System.out.println("New Location of minimum Slider(x:y) is: " + new_minsliderlocation);	
		System.out.println("New Location of maximum Slider(x:y) is: " + new_maxsliderlocation);	

		driver.quit();
	}

}
