package learning.switchto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameOrIframe {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		WebElement frame1 = driver.findElement(By.cssSelector("frame[src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		
		WebElement textField1 = driver.findElement(By.xpath("//*[@id='id1']/div/input"));
		textField1.sendKeys("Welcome dost!");
		driver.switchTo().defaultContent();
		 
		Thread.sleep(2000);
		driver.close();
		
	}

}
