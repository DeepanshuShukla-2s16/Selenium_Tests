package learning.mouseOverActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.plus2net.com/javascript_tutorial/ondblclick-demo2.php");
		
		WebElement btn = driver.findElement(By.xpath("/html/body/input"));
		Thread.sleep(1000);
		
		//double click action on the button
		Actions action = new Actions(driver);
		action.doubleClick(btn).build().perform();
		Thread.sleep(2000);
		System.out.println("test passed!");
		

	}

}
