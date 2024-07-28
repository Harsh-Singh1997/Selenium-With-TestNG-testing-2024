package dataDrivenTestingUsingSelenium;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ExcelUtilitiesForDataDrivenTesting.ExcelUtility;

public class DataDrivenTesting_UsingExcelUtilities {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		String xlsFile = System.getProperty("user.dir") + "\\Test-File\\DynamicTest1.xlsx";
		
		ExcelUtility Reader = new ExcelUtility(xlsFile);
		
		String sheet=Reader.getSheetName(xlsFile);
		
		System.out.println("Sheet Name: " + sheet);
		
		int rownum = Reader.getRowCount(sheet);
		
		System.out.println("Row Number: " + rownum);
			
		for(int i = 2;i<=rownum;i++) {
			
			//Read data of cell from row
			String firstname = Reader.getCellData(sheet, 0, i);
			String lastname = Reader.getCellData(sheet, 1, i);
			String address = Reader.getCellData(sheet, 2, i);
			String emailAddr = Reader.getCellData(sheet, 3, i);
			String phone = Reader.getCellData(sheet, 4, i);
			String gender = Reader.getCellData(sheet, 5, i);
			
			//Enter data into application by passing it to webelement
			
			WebElement frstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
			frstName.clear();
			frstName.sendKeys(firstname);
			Thread.sleep(500);
			
			WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		    lastName.clear();
			lastName.sendKeys(lastname);
			Thread.sleep(500);
			
			WebElement addr = driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
			addr.clear();
			addr.sendKeys(address);
			Thread.sleep(500);
			
			WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
			email.clear();
			email.sendKeys(emailAddr);
			Thread.sleep(500);
			
			WebElement phonenum = driver.findElement(By.xpath("//input[@type='tel']"));
			phonenum.clear();
			phonenum.sendKeys(phone);
			Thread.sleep(500);
			
			if(gender.equals("Male")) {
			driver.findElement(By.xpath("//label[normalize-space()='Male']//input")).click();			
		}
			if(gender.equals("Female")) {
				driver.findElement(By.xpath("//label[normalize-space()='FeMale']//input")).click();			
			}
			
			//Validation
			WebElement male = driver.findElement(By.xpath("//label[normalize-space()='Male']//input"));
			WebElement female = driver.findElement(By.xpath("//label[normalize-space()='FeMale']//input"));
			
		    if(male.isSelected()||female.isSelected()) {
		    	System.out.println("Test passed");
		    	Reader.setCellData(sheet,"Test Status", i, "PASS");
		    }
		    else{
		    	System.out.println("Test failed");
		    	Reader.setCellData(sheet,"Test Status", i, "FAIL");
		    }		    	
		
	}

		driver.quit();
	}
		
	}


