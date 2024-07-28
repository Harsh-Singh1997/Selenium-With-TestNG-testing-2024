package webTestUsingSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingSelectDropDowns {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement dropdownoption = driver.findElement(By.xpath("//select[@id='country']"));
		
		//Select Dropdown method
		
		Select country = new Select(dropdownoption);
		
		//Select option by visible text in dropdown:
		
		country.selectByVisibleText("Germany");
		Thread.sleep(2000);
		
		//Select option by value in dropdown:
		
		country.selectByValue("japan");
		Thread.sleep(2000);
		
		//Select option by Index of dropdown:
		
		country.selectByIndex(1);
		Thread.sleep(5000);
		
		//Finding number of options in dropdown
		
		List<WebElement>countryoptions=country.getOptions();
		System.out.println("Number of options in Country Dropdown: "+countryoptions.size()+ '\n');
		
		//Printing all options from dropdown using for loop
		
		System.out.println("Printing all options from dropdown using for loop");
		for(int i = 0;i<countryoptions.size();i++) {
			System.out.println(countryoptions.get(i).getText());
		}
		
		//Printing all options from dropdown using enhanced for loop
		
		System.out.println('\n'+ "Printing all options from dropdown using enhanced for loop");
		for(WebElement op:countryoptions) {
			System.out.println(op.getText());
		}
		
		driver.close();

	}

}
