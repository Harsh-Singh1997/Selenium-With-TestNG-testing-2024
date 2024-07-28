package webTestUsingSelenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSL_HandlingDemo {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options= new ChromeOptions();
		options.setAcceptInsecureCerts(true); // For Handling insecure SSL
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://expired-rsa-dv.ssl.com/?_gl=1*1vm4i6f*_gcl_au*NjQxMTE2MTQyLjE3MjA3MDcxNzU.");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);

		System.out.println("TITLE: " + driver.getTitle());
		
		driver.quit();
	}

}
