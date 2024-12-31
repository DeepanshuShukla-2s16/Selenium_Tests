package learning.headlessTesting;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableExtensionAtRunTime {

	public static void main(String[] args) throws InterruptedException {
		File source = new File("C:\\Users\\deepanshu\\Downloads\\uBlock-Origin-Chrome-Web-Store.crx");
		ChromeOptions opt = new ChromeOptions();
		opt.addExtensions(source);
		
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://text-compare.com/");
		
		Thread.sleep(2000);
		driver.quit();
	}
}
