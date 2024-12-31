package learning.mouseOverActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAction {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		WebElement countryFrom = driver.findElement(By.xpath("//*[@id='box1']"));
		
		WebElement countryTo = driver.findElement(By.xpath("//*[@id='box106']"));
		Thread.sleep(2000);
		//drag and drop action perform
		Actions action = new Actions(driver);
		 
		//dropping wrong place
		action.dragAndDrop(countryFrom, countryTo);
		Thread.sleep(2000);
		
		countryTo = driver.findElement(By.xpath("//*[@id='box101']"));
		
		//dragging wrong place to correct place
		action.dragAndDrop(countryFrom, countryTo).perform();
		Thread.sleep(2000);
		System.out.println("test passed!");
		driver.close();
		
		

	}

}
