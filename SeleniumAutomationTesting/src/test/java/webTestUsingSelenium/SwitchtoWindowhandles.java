package webTestUsingSelenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchtoWindowhandles {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		//Get all WindowHandles
		
		Set<String> windowIds = driver.getWindowHandles();
		/*
		//Switching between window handles - Approach 1
		
		List<String> WindowIDList= new ArrayList(windowIds);
		
		String parentID = WindowIDList.get(0);
		String childID = WindowIDList.get(1);
		
		System.out.println("Parent Window handle ID: " + parentID);
		System.out.println("Child Window handle ID: " + childID);
		
		//Switch to child Window
		driver.switchTo().window(childID);
		System.out.println("Child window page title: "+driver.getTitle());
		
		//Switch to parent Window
		driver.switchTo().window(parentID);
		System.out.println("Parent window page title: "+driver.getTitle());
		*/
		
		//Switching between window handles - Approach 2
		
		for(String winID: windowIds) {
			
			String title = driver.switchTo().window(winID).getTitle();
			
			if(title.equals("OrangeHRM")) {
				System.out.println("Current URL: " + driver.getCurrentUrl());
			}else {
				System.out.println("Current URL: " + driver.getCurrentUrl());
			}
		}
		
		
		
		driver.quit();
		
	}

}
