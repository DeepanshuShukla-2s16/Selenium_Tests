package learning.headlessTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleChromeControlledByAutomatedSoftware {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://expired.badssl.com/");
		
		String act_title = driver.getTitle();
		System.out.println(act_title);
		Thread.sleep(1000);
		
//		driver.quit();
	}
}
