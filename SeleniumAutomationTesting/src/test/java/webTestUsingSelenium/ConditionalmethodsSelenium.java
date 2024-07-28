package webTestUsingSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalmethodsSelenium {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		
		
		//isDisplayed()
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		System.out.println("Logo Display Status: " + logo.isDisplayed());
		System.out.println();
		
		//isEnabled()
		WebElement firstname = driver.findElement(By.xpath("//input[@id='FirstName']"));
		System.out.println("First Name box enable status: " + firstname.isEnabled());
		System.out.println();
		
		//isSelected()
		System.out.println("Male checkbox clicked:");
		WebElement mcheckbox = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement fcheckbox = driver.findElement(By.xpath("//input[@id='gender-female']"));
		mcheckbox.click();
		System.out.println("Male checkbox selected status: " + mcheckbox.isSelected());
		System.out.println("Female checkbox selected status:" + fcheckbox.isSelected());
		System.out.println();
		
		System.out.println("Female checkbox clicked:");
		fcheckbox.click();
		System.out.println("Female checkbox selected status:" + fcheckbox.isSelected());
		System.out.println("Male checkbox selected status: " + mcheckbox.isSelected());
		System.out.println();
		
		WebElement newsletter = driver.findElement(By.xpath("//input[@id='Newsletter']"));
		System.out.println("Newletter checkbox selected status: " + newsletter.isSelected());
		

	}

}
