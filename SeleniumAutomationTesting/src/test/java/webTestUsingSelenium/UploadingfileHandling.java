package webTestUsingSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadingfileHandling {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		
//		//uploading single file on site
//		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("G:\\Test files\\Test1.txt");
//		
//		String filename = driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText();
//		
//		if(filename.equals("Test1.txt")) {
//			System.out.println("File is uploaded SUCCESSFULLY :) ");
//		}
//		else {
//			System.out.println("File Upload FAILED :( ");
//		}
		
		//Uploading multiple files on site
		
		String file1 = "G:\\\\Test files\\\\Test1.txt";
		String file2 = "G:\\\\Test files\\\\Test2.txt";
		
		WebElement uploadFile = driver.findElement(By.xpath("//input[@id='filesToUpload']"));
		
		uploadFile.sendKeys(file1 + '\n' + file2); //Uploading multiple files
		
		List<WebElement> filesUploaded = driver.findElements(By.xpath("//ul[@id='fileList']//li"));
		int numberofFiles = filesUploaded.size();
		
		for(int i = 0; i< numberofFiles ; i++) {
			
			if(filesUploaded.get(i).getText().equals("Test1.txt") || filesUploaded.get(i).getText().equals("Test2.txt")) {
				
				System.out.println("Files Uploaded Successfully ............ ");
			}else {
				System.out.println("Files uploaded Unsuccessfully...........");
			}	
			System.out.println("Files "+(i+1)+" :" + filesUploaded.get(i).getText());
		}
		
		driver.quit();
		
}

}
