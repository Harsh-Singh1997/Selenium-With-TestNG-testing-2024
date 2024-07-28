package webTestUsingSelenium;

import java.net.SocketException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class LaunchBrowerTest {

	public static void main(String[] args) throws SocketException {
		
		//Launch Browser in chrome
		WebDriver driver = new ChromeDriver();
		
		//Open URL
		
		driver.get("https://demo.opencart.com");
		
		String act_title = driver.getTitle();
		
		if(act_title.equals("Your Store")) {
		System.out.println("Title matches: " + driver.getTitle());
		}
		else {System.out.println("Title not matches");
		}
		
		driver.quit();
		
		//Launch Browser in Edge
				WebDriver driver1 = new EdgeDriver();
				
				//Open URL
				
				driver1.get("https://demo.opencart.com");
				
				String act_title1 = driver1.getTitle();
				
				if(act_title.equals("Your Store")) {
				System.out.println("Title matches: " + driver1.getTitle());
				}
				else {System.out.println("Title not matches");
				}
				
				driver1.quit();
		

	}

}
