package webTestUsingSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBootStrapDropDowns {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		//clicking Bootstrap Dropdown
		
		driver.findElement(By.xpath("//button[contains(@class,'multiselect dropdown-toggle')]")).click();
		
		//Clicking single element in dropdown:
		
		driver.findElement(By.xpath("//input[@value='Java']")).click();
		
		//List of checkboxes in dropdown
		
		List<WebElement> btcheckboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(WebElement cb: btcheckboxes) {
			
			if(cb.isSelected()) {
				cb.click();  //unckecking all selected checkboxes
				Thread.sleep(2000);
			}
		}
		
		//List of all WebElements in dropdown
		
		List<WebElement>Options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container dropdown-menu')]//label"));
		
		for(WebElement op:Options) {
			
			System.out.println(op.getText()); // Getting list of all options in dropdown
			
			String dropdownop = op.getText();
			if(dropdownop.equals("Bootstrap") || dropdownop.equals("Angular")|| dropdownop.equals("C#")) {
				op.click();
				Thread.sleep(2000);
			}
		}
		
		driver.quit();
	}

}
