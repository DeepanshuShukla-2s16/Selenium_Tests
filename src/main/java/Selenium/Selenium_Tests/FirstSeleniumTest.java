package Selenium.Selenium_Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {

	public static void main(String[] args) {
		
		//lounch browser
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");

		String title = driver.getTitle();
		
		if(title.equals("Web form")) {
			System.out.println("assertion passed");
		}else {
			System.err.println("test failed");
			System.exit(0);
		}

		//finding the test field
		WebElement textBox = driver.findElement(By.name("my-text"));
		//finding the button
		WebElement submitButton = driver.findElement(By.cssSelector("button"));
		// insert some test
		textBox.sendKeys("John");
		//submitting form 
		submitButton.click();
		
		
		//finding the response msg
		WebElement message = driver.findElement(By.id("message"));
		String submitValue = message.getText();
		
		if(submitValue.equals("Received!")) {
			System.out.println("assertion passed!");
		}else {
			System.err.println("Test failed!");
			System.exit(0);
		}
			
		driver.quit();
		
	}
}
