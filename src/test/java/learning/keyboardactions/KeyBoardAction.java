package learning.keyboardactions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardAction {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://text-compare.com/");
		
		WebElement firstArea = driver.findElement(By.xpath("//*[@id=\"inputText1\"]"));
		
		firstArea.sendKeys("Welcome Dost!");
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		//Ctrl + A - select all text
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		Thread.sleep(1000);
		
		//Ctrl + C - copy the selected text
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		Thread.sleep(1000);
		
		//tab - switch to other textarea
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		Thread.sleep(1000);
		
		//Ctrl + V - paste the copied text
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		Thread.sleep(1000);
		System.out.println("test passed!");
		driver.close();
	}
}
