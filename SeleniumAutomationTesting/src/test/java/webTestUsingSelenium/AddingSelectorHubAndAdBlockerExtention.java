package webTestUsingSelenium;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddingSelectorHubAndAdBlockerExtention {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		
		File SelectorHubExtFile = new File("G:\\Extention files\\SelectorsHub-Chrome-Web-Store.crx"); //selector Hub CRX extension file
		
		File AdBlockerExtFile = new File("G:\\Extention files\\AdBlocker-Ultimate-Chrome-Web-Store.crx"); //adBlocker CRX extension file
		
		// Add Selector Hub Extension plugin in automated test UI.
		options.addExtensions(SelectorHubExtFile); 
		
		//Add AdBlocker Extension plugin in automated test UI.
		options.addExtensions(AdBlockerExtFile); 
				
	    WebDriver driver = new ChromeDriver(options);
	    
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://text-compare.com/");
		
		driver.manage().window().maximize();
		
		Set<String> winhandle= driver.getWindowHandles();
		
		List<String> wh = new ArrayList(winhandle);
		
		String clildWindow = wh.get(1);

		driver.switchTo().window(clildWindow);
		
		driver.close();
		
		Thread.sleep(7000);
		
		driver.quit();
		
		

	}

}
