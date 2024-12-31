package learning.headlessTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BadSSLHandle {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		opt.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(opt);
		
		driver.get("https://expired.badssl.com/");
		
		String act_title = driver.getTitle();
		System.out.println(act_title);
		Thread.sleep(1000);
		
		driver.quit();
	}
}
