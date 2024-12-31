package learning.mouseOverActions;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOverAction {

//	public static void main(String[] args) {
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://demo.opencart.com/");
//		WebElement desktop = driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[1]/a"));
//		WebElement mac = driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[1]/div/div/ul/li[2]/a"));
//		Actions action = new Actions(driver);
//		action.moveToElement(desktop).moveToElement(mac).click().build().perform();
//		System.out.println("Test passed!");
//	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demo.opencart.com/");
		WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/a/span"));
		System.out.println("my account find");
		WebElement login = driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[2]/a"));
		System.out.println("login find");
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(myAccount).click().perform();
		Thread.sleep(2000);
//		action.moveToElement(login).build().perform();
//		Thread.sleep(2000);
		System.out.println("Test passed!");
	}	
	
}

