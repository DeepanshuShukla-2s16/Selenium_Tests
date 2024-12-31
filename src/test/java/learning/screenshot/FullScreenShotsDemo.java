package learning.screenshot;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FullScreenShotsDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		
		//take screenshot of the full screen  
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		Thread.sleep(1000);
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\ScreenShots\\fullpage.png");
		source.renameTo(target);
		
		Thread.sleep(2000);
		System.out.println("test passed!");
		driver = (WebDriver)driver;
		driver.close();
		
		
		
	}
}
