package webTestUsingSelenium;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerHandling {
	
	//Method for selecting future Month and Year
	public static void futuremonthandyear(WebDriver driver,String Month,String Year) throws InterruptedException {
		while(true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			//check date and year
			
			if(currentMonth.equals(Month) && currentYear.equals(Year)) {
				
				break;
			}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			Thread.sleep(100);

			}
	}
	
	//Method for selecting past Month and Year
		public static void pastmonthandyear(WebDriver driver,String Month,String Year) throws InterruptedException {
			while(true) {
				String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
				String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
				
				//check date and year
				
				if(currentMonth.equals(Month) && currentYear.equals(Year)) {
					
					break;
					
				}
				
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
				Thread.sleep(100);

				}
		}
	
	//Method for selecting date
	public static void datepicker(WebDriver driver,String Day) {
		List<WebElement> str_date = driver.findElements(By.xpath("//tbody//td//a[contains(@class,'ui-state-default')]"));
		for(WebElement day: str_date) {
		if(day.getText().equals(Day)) {
			day.click();
			break;
		}
		}
	}
	

	public static void main(String[] args) throws InterruptedException {
		
		String Day= new String();
		String Month= new String();
		String Year= new String();
		
		Scanner sf = new Scanner(System.in);
		
		System.out.println("Enter Day: ");
		Day = sf.next();
		
		System.out.println("Enter Month: ");
		Month = sf.next();
		
		System.out.println("Enter Year: ");
		Year = sf.next();
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		//switch to date frame
		driver.switchTo().frame(0);
		
		
	/*
		//Static date entry method
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/05/2025");
		Thread.sleep(5000);
		
		*/
		
		//using date picker box
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		if(Integer.parseInt(Year)>2024) {
		
		futuremonthandyear(driver,Month,Year); // calling month and year method
		
		datepicker(driver,Day); // calling date picker method
		Thread.sleep(2000);
		}else {
			pastmonthandyear(driver,Month,Year); // calling month and year method
			
			datepicker(driver,Day); // calling date picker method
			Thread.sleep(2000);
		}
			
		driver.quit();
	}

}
