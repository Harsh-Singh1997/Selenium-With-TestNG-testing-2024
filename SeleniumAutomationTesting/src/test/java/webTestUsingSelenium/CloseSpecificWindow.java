package webTestUsingSelenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseSpecificWindow {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		//Get all WindowHandles
		
		Set<String> windowIds = driver.getWindowHandles();
		
for(String winID: windowIds) {
			
			String title = driver.switchTo().window(winID).getTitle();
			
			System.out.println(title);
			
			//closing child window
			if(title.equals("Human Resources Management Software | OrangeHRM")) {
				driver.close();
			}
		}
	}

}
