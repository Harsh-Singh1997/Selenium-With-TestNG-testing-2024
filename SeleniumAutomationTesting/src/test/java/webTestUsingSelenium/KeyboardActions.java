package webTestUsingSelenium;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) throws InterruptedException {
		
		String str = new String();
		
		Scanner sf = new Scanner(System.in);
		
		System.out.println("Enter text for box 1: ");
		str = sf.nextLine();
		
		    WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://text-compare.com/");
			driver.manage().window().maximize();
			
			Actions Keyboard = new Actions(driver);
			
			//Enter text in box 1
			
			WebElement textbox1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
			textbox1.sendKeys(str);
			
			//KeyBoard Actions:
			//Ctrl + A - for selecting all text
			//Ctrl + C - for copying selected text
			//Ctrl + V - for pasting the copied text
			
			//Select all text
			Keyboard.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			Thread.sleep(2000);
			
			//Copy selected text
			Keyboard.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
			
			//shift to second tab:
			Keyboard.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
			
			//paste the text in second tab:
			Keyboard.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
			Thread.sleep(2000);
			
			WebElement textbox2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));
			String text2 = textbox2.getText();
			
			if(text2.equals(str)) {
				System.out.println("Text in box 1 matches text in box 2");
				System.out.println("Text in box 2 is: " + text2);
			}else {
				System.out.println("ERROR: Text DOES NOT MATCH :( ");	
				System.out.println("Text in box 2 is: " + text2);
			}

	}

}
