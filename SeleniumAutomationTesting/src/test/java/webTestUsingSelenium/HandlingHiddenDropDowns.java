package webTestUsingSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingHiddenDropDowns {

	public static void main(String[] args) throws InterruptedException {
		
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']"))).sendKeys("Admin");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']"))).sendKeys("admin123");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Login']"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='PIM']"))).click();
		
		// clicking on Dropdown button
		//driver.findElement(By.xpath("//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[6]")).click(); 
		
		try {
		//using explictit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[6]"))).click();
		
		
		//click on single element
		/*
		driver.findElement(By.xpath("//div[@role='listbox']//span[contains(.,'Automaton Tester')]")).click();
		Thread.sleep(3000);
		*/
		
		//list of all hidden options
		
		List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='listbox']//span")));
		
		System.out.println("Number of options in dropdown: " + options.size());
		for(WebElement op:options) {
			String slop = op.getText(); // get all options in hidden dropdown
			System.out.println(slop);
			
			if(slop.equals("Financial Analyst")) {
				op.click();
				Thread.sleep(3000);
			}			
		}
		}catch(StaleElementReferenceException e) {}
		driver.quit();
	}

}
