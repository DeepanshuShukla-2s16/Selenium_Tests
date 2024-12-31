package learning.mouseOverActions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement contextBtn = driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));
		
		Actions action = new Actions(driver);
		
		action.contextClick(contextBtn).perform();
		Thread.sleep(2000);
		
		//copy the element
		WebElement copyContextMenu = driver.findElement(By.xpath("/html/body/ul/li[3]/span"));
		
		//click on copy
		action.contextClick(copyContextMenu).perform();
		
		Thread.sleep(2000);
		
		//handle alert popup window
		Alert alrt = driver.switchTo().alert();
		//close alert window
		alrt.accept();
		
		System.out.println("test passed!");
		
		
	}
}
