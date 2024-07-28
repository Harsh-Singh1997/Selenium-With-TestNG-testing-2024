package webTestUsingSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingUsingJavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://snapdeal.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
	//scroll to a certain pixels using Javascript
//		js.executeScript("window.scrollBy(0,900)", "");
//		System.out.println(js.executeScript("return window.pageYOffset;", "")); //provide dimension of y axis 

	//scroll to a certain WeElement on page:
//		WebElement topheading = driver.findElement(By.xpath("//i[@class='paymentIcon footerIconsImg']"));
//		
//		js.executeScript("arguments[0].scrollIntoView()", topheading);
//		System.out.println(js.executeScript("return window.pageYOffset;", "")); //2040
		
   //scroll till end of page
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
		System.out.println(js.executeScript("return window.pageYOffset;", "")); //2283.199951171875
		
		Thread.sleep(3000);
		
		//scroll till top of page
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)","");		
		System.out.println(js.executeScript("return window.pageYOffset;", "")); //0
		
//		//Scrolling horizontally on X axis:
//		js.executeScript("window.scrollBy(0,document.body.scrollWidth)","");
//		System.out.println(js.executeScript("return window.pageYOffset;", ""));
		
		
	}

}
