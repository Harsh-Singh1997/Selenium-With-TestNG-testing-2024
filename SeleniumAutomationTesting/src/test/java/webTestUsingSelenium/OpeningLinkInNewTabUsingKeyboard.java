package webTestUsingSelenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpeningLinkInNewTabUsingKeyboard {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		Actions KeyB = new Actions(driver);
		
		WebElement registry_Link = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		
		//Opening link in New TAB: Hold Ctrl and click on link
		
		KeyB.keyDown(Keys.CONTROL).click(registry_Link).keyUp(Keys.CONTROL).perform();
		
		
		//Getting parent and child window handles
		Set<String> windowtabs = driver.getWindowHandles();
		
		List<String> wintab = new ArrayList(windowtabs);
		
		String parentID = wintab.get(0);
		String childID = wintab.get(1);
		
		//switching window
		driver.switchTo().window(childID);
		
		//select male radiobutton:
		driver.findElement(By.xpath("//input[@id='gender-male']")).click();
		
		//Enter First Name:
		driver.findElement(By.xpath("//input[@id='FirstName']")).clear();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Chris");
		
		//Enter Last Name:
		driver.findElement(By.xpath("//input[@id='LastName']")).clear();
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Redfield");
		
		//Select Date of Birth
		Select dob_Day = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		Select dob_Month = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		Select dob_Year = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		dob_Day.selectByVisibleText("15");
		dob_Month.selectByVisibleText("July");
		dob_Year.selectByVisibleText("1981");
		
		//Select Email:
		WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
		email.sendKeys("ChrisRedfield@BSAA.com");
	}

}
