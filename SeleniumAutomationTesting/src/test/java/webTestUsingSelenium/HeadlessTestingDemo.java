package webTestUsingSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTestingDemo {

	public static void main(String[] args) {
		
		// Headless testing - Running testcase in backend without launching UI
		
		//Advantage: 
		//Can do multiple tasks(Since testing happens in backend)
		//Faster execution than normal testing
		
		//Disadvantage:
		//Difficult to understand what is happening in backened by other tester
		
		
		ChromeOptions options = new ChromeOptions(); //need to add class ChromeOptions for headless testing
		
		options.addArguments("--headless=new"); //settings for Headless testing
		
        WebDriver driver = new ChromeDriver(options);
		
		//Open URL
		
		driver.get("https://www.amazon.in/");
		
		String act_title = driver.getTitle();
		
		System.out.println("Title: " + act_title);
		
		if(act_title.equals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")) {
		System.out.println("Title matches: " + driver.getTitle());
		}
		else {System.out.println("Title not matches");
		System.out.println("Title: " + act_title);
		}
		
		driver.quit();
		
		

	}

}
