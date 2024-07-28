package webTestUsingSelenium;

import java.time.Duration;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AuthenticationPopupAlert {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//need to inject username and password in URL only. Syntax: Https://username:password@"webpage without Https://"
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth"); 
		driver.manage().window().maximize();
		
		WebElement message = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]"));
		
		System.out.println(message.getText()); // print message text of page
		
}
	
}
