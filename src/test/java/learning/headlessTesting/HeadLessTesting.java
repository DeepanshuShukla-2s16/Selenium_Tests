package learning.headlessTesting;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeadLessTesting {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/");
		String currentTitle = driver.getTitle();
		if(currentTitle.equals("Your Store")) {
			System.out.println("test passes!");
		}else {
			System.out.println("test failed!");
		}
		
		
		
		
		driver.quit();

	}

}
