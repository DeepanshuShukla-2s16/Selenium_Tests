package learning.dataDrivenTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import learning.excel.utils.ExcelUtils;

public class FDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();

		WebElement principleWebElm = driver.findElement(By.xpath("//*[@id=\"principal\"]"));
		WebElement rateOfInterestWebElm = driver.findElement(By.xpath("//*[@id=\"interest\"]"));
		WebElement period1WebElm = driver.findElement(By.xpath("//*[@id=\"tenure\"]"));
		WebElement period2WebElm = driver.findElement(By.xpath("//*[@id=\"tenurePeriod\"]"));
		WebElement frequencyWebElm = driver.findElement(By.xpath("//*[@id=\"frequency\"]"));
		WebElement maturityWebElm = driver.findElement(By.xpath("//*[@id=\"resp_matval\"]"));
		WebElement calculateBtn = driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]"));
		WebElement clearBtn = driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[2]"));

		String filePath = System.getProperty("user.dir") + "\\testdata\\DataFile.xlsx";
		String sheet = "Sheet1";
		int rows = ExcelUtils.getRowCount(filePath, sheet);

		for (int i = 1; i <= rows; i++) {
			
			String principle = ExcelUtils.getCellData(filePath, sheet, i, 0);
			String rateOfInterest = ExcelUtils.getCellData(filePath, sheet, i, 1);
			String period1 = ExcelUtils.getCellData(filePath, sheet, i, 2);
			String period2 = ExcelUtils.getCellData(filePath, sheet, i, 3);
			String frequency = ExcelUtils.getCellData(filePath, sheet, i, 4);
			String exp_maturity = ExcelUtils.getCellData(filePath, sheet, i, 5);
			System.out.println("exp maturity : " + exp_maturity);

			principleWebElm.sendKeys(principle);
			rateOfInterestWebElm.sendKeys(rateOfInterest);
			period1WebElm.sendKeys(period1);
			Select tenurePeriod = new Select(period2WebElm);
			tenurePeriod.selectByContainsVisibleText(period2);
			Select frequencySelect = new Select(frequencyWebElm);
			frequencySelect.selectByContainsVisibleText(frequency);

//			calculateBtn.click();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", calculateBtn);

			String act_maturity = maturityWebElm.getText();
			
			if (Double.parseDouble(exp_maturity) == Double.parseDouble(act_maturity)) {
				ExcelUtils.setCellData(filePath, sheet, i, 7, "Pass");
				ExcelUtils.fillGreenColor(filePath, sheet, i, 7);
			} else {
				ExcelUtils.setCellData(filePath, sheet, i, 7, "Fail");
				ExcelUtils.fillRedColor(filePath, sheet, i, 7);
			}
			Thread.sleep(2000);
			js.executeScript("arguments[0].click();", clearBtn);
			driver = (WebDriver)driver;
		}

		
		driver.quit();

	}

}
