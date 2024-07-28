package webTestUsingSelenium;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenLinksDemo {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");

		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://www.deadlinkcity.com/");
		
		driver.manage().window().maximize();
		
		//find all links on page:
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links: " + links.size());
		
		
		int noOfBrokenLinks=0;
		int noOFNonBrokenLinks=0;
		
		//find all broken and non broken links:
		for(WebElement pagelinks: links) {
			
			String pglink = pagelinks.getAttribute("href");
			
			if(pglink == null || pglink.isEmpty()) {
				
				System.out.println("Link is null or empty. Not possible to find broken link");
				continue; //skip to next link
			}
			
			try {
			URL linkURL = new URL(pglink); // change link from string to URL format
			
			HttpURLConnection conn=(HttpURLConnection) linkURL.openConnection(); //open connection to server
			
			conn.connect(); // connect link to server and send request to server
			
			if(conn.getResponseCode()>=400) {
				
				System.out.println(linkURL +  "======>Link is broken. " + "ResponseCode: " + conn.getResponseCode());
				noOfBrokenLinks++;
			}else {
				System.out.println(linkURL +  "======>Link is not broken. " + "ResponseCode: " + conn.getResponseCode());
				noOFNonBrokenLinks++;
			}
			}catch(Exception e) {
				
			}			
			
		}
		
		System.out.println("Number of Broken Links: " + noOfBrokenLinks);
		System.out.println("Number of non Broken Links: " + noOFNonBrokenLinks);
		
	}

}
