package webTestUsingSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigatemethods {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://demo.nopcommerce.com/register");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().refresh();

	}

}
