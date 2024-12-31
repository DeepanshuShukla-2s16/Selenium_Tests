package learning.dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static void main(String[] args) throws IOException {
		 FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\Book.xlsx");
		 
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheet("Sheet1");
		 
		 int totalRows = sheet.getLastRowNum();
		 int totalCells = sheet.getRow(1).getLastCellNum();

		 System.out.println("tatal Rows : "+totalRows);
		 System.out.println("tatal Rows : "+totalCells);
		 
		 for (int r = 0; r < totalRows; r++) {
			 XSSFRow row = sheet.getRow(r);
			for (int col = 0; col < totalRows; col++) {
				System.out.print(row.getCell(col)+"  ");
			}
			System.out.println();
		}
	}
}
