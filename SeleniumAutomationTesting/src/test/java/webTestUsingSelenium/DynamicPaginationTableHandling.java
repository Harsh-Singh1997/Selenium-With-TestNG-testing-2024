package webTestUsingSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationTableHandling {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://datatables.net/examples/basic_init/alt_pagination.html");
		driver.manage().window().maximize();

		
		WebElement example = driver.findElement(By.xpath("//div[@id='example_info']"));
		
		String str = example.getText();
		
		String npages = str.substring(str.indexOf("f")+2, str.indexOf("e")-1);
		
		int num = Integer.parseInt(npages);
		
		System.out.println("Total Entries: " + num);
		
		List<WebElement> tbuttons = driver.findElements(By.xpath("//div//button[@class='dt-paging-button' and @tabindex=0]"));
		System.out.println("Total clickable buttons: " + tbuttons.size());
		
		/*
		try {
		
			//click on all buttons in dynamic table
		for(int p = 1;p<=tbuttons.size();p++) {
			
			if(p>1) {
				driver.findElement(By.xpath("//div//button[@class='dt-paging-button' and @data-dt-idx="+p+"]")).click();
				Thread.sleep(3000);
			}
			
			}
			
		}catch(StaleElementReferenceException e){
			
		}
		*/
		
		//find particular element in page and tell page number in which it present
		try {
						
		for(int p = 1;p<=tbuttons.size();p++) {	
			if(p>=1) {
				List<WebElement> adata = driver.findElements(By.xpath("//table[@id='example']//tbody//tr//td[1]"));	
			for(int i = 1; i < adata.size();i++) {
				String Expected_data = "Paul Byrd";
				String Actual_data = adata.get(i).getText();
			if(Actual_data.equals(Expected_data)) {
				System.out.println("Page on which data present:" + p);
				System.out.println("Row Number: " + i++);
				List<WebElement> rowdata = driver.findElements(By.xpath("//table[@id = 'example']//tbody//tr["+(i++)+"]//td"));
				System.out.print("Data: ");
				for(WebElement rd: rowdata) {
					String rdata = rd.getText();
					System.out.print( rdata + '\t');
				}
				break;
			}
			
			}
			
			}
				driver.findElement(By.xpath("//div//button[@class='dt-paging-button' and @data-dt-idx="+p+"]")).click();
				Thread.sleep(100);
		}
			
		}catch(StaleElementReferenceException e){
			
		}
		
		driver.quit();
	}
	
}


