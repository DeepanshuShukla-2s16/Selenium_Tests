package learning.mouseOverActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SlidderAction {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/#google_vignette");
		driver.manage().window().maximize();
		
		WebElement minSlidder = driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[1]"));		
		Actions action = new Actions(driver);
		action.dragAndDropBy(minSlidder, +23, minSlidder.getLocation().getY()).release().build().perform();
		
		
		Thread.sleep(2000);
		WebElement maxSlidder = driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[2]"));
		action.dragAndDropBy(maxSlidder, -106, maxSlidder.getLocation().getY()).release().build().perform();
		Thread.sleep(2000);
		System.out.println("test passed!");
		driver.close();
	}
	
//	public static void main(String[] args) throws InterruptedException {
//	    WebDriver driver = new ChromeDriver();
//	    driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/#google_vignette");
//	    driver.manage().window().maximize();
//
//	    // Locate the min slider
//	    WebElement minSlidder = driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[1]"));
//
//	    // Use Actions class to move the slider
//	    Actions action = new Actions(driver);
//	    action.clickAndHold(minSlidder) // Click and hold the slider
//	          .moveByOffset(23, minSlidder.getLocation().getY()) // Move it horizontally
//	          .release() // Release the slider
//	          .build()
//	          .perform();
//	    Thread.sleep(2000);
//
//	    // Locate the max slider
//	    WebElement maxSlidder = driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[2]"));
//
//	    // Move the max slider
//	    action.clickAndHold(maxSlidder) // Click and hold the slider
//	          .moveByOffset(-106, maxSlidder.getLocation().getY()) // Move it horizontally
//	          .release() // Release the slider
//	          .build()
//	          .perform();
//	    Thread.sleep(2000);
//
//	    System.out.println("test passed!");
//	    driver.close();
//	}

}
