package webTestUsingSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTablehandling {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		//total number of rows
		int row = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Total number of rows: " + row);
		
		//total number of column
		int cols = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("total number of columns: " + cols);
		
		//finding specific data in table(example: 1st row + 3 column data)
		
		String data = driver.findElement(By.xpath("//table[@name='BookTable']//tr[2]//td[3]")).getText();
		System.out.println("Data in 1st row and 3rd column is: "+data);
		
		//finding data from single row(Example data from 3rd row
		for(int i = 1;i<=cols;i++) {
		String rdata = driver.findElement(By.xpath("//table[@name='BookTable']//tr[4]//td["+i+"]")).getText();
		System.out.println(rdata);
		}	System.out.println();
		
		//finding data from single cloumn(Example: data from Bookname column)
		for(int j = 2; j <= row ; j++) {
			String cdata = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+j+"]//td[1]")).getText();
			System.out.println(cdata);	
		}
		System.out.println();
		
		//finding all headers in table
		for(int k =1; k<=cols;k++) {
		String header = driver.findElement(By.xpath("//table[@name='BookTable']//tr//th["+k+"]")).getText();
		System.out.println(header);
		}System.out.println();
		
		//printing all data in table
		for(int r=2;r<=row;r++) {
			for(int c = 1;c<=cols;c++) {
				String alldata = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(alldata+'\t');
			}
			System.out.println();
		}
		System.out.println();
		
		//conditional searching(Example: Find all books whose author is Amit)
		for(int x = 2;x<=row;x++) {
			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+x+"]//td[2]")).getText();
			
			if(author.equals("Amit")) {
				String bookname = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+x+"]//td[1]")).getText();
				System.out.println("Author: " + author + 't' + "Bookname: " + bookname);
			}
		}
		System.out.println();
		
		//Finding total price of books:
		int total = 0;
		for(int y = 2;y<=row;y++) {
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+y+"]//td[4]")).getText();
			total = total+ Integer.parseInt(price); // wrapper class to convert string price in integer datatype
		}
		System.out.println("Total price of books is: " + total);
		
		driver.quit();
	}

}
