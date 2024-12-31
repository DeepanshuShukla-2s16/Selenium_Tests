package learning.dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataInExcel {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testdata\\myFile.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("data");
		
		XSSFRow row0 = sheet.createRow(0);
		row0.createCell(0).setCellValue("Java");
		row0.createCell(1).setCellValue("19");
		row0.createCell(2).setCellValue("Automation");
		row0.createCell(3).setCellValue("12-Feb-2024");
		
		
		XSSFRow row1 = sheet.createRow(1);
		row1.createCell(0).setCellValue("Python");
		row1.createCell(1).setCellValue("3");
		row1.createCell(2).setCellValue("Automation");
		row1.createCell(3).setCellValue("27-Mar-2024");

		XSSFRow row2 = sheet.createRow(2);
		row2.createCell(0).setCellValue("HTML");
		row2.createCell(1).setCellValue("5");
		row2.createCell(2).setCellValue("Automation");
		row2.createCell(3).setCellValue("01-Dec-2024");
		
		
		workbook.write(file);
		workbook.close();
		file.close();
	}

}
