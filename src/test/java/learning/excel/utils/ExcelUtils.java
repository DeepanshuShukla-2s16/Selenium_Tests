package learning.excel.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fileInputStream;
	public static FileOutputStream fileOutputStream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle cellStyle;
	
	public static int getRowCount(String excelFile, String excelSheet) throws IOException
	{
		fileInputStream = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(excelSheet);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fileInputStream.close();
		return rowCount;
	}
	
	public static int getCellCount(String excelFile, String excelSheet, int rowNum) throws IOException
	{
		fileInputStream = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(excelSheet);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fileInputStream.close();
		return cellCount;
	}
	
	public static String getCellData(String excelFile, String excelSheet, int rowNum, int colNum) throws IOException
	{
		fileInputStream = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(excelSheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		String data;
		try {
//			data = cell.toString();
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);
		}
		catch (Exception e) {
			data = "";
		}
		workbook.close();
		fileInputStream.close();
		return data;	
	}
	
	public static void setCellData(String excelFile, String excelSheet, int rowNum, int colNum, String data) throws IOException
	{
		fileInputStream = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(excelSheet);
		row = sheet.getRow(rowNum);
		
		cell = row.createCell(colNum);
		cell.setCellValue(data);
		fileOutputStream = new FileOutputStream(excelFile);
		workbook.write(fileOutputStream);
		workbook.close();
		fileInputStream.close();
		fileOutputStream.close(); 
	}
	
	public static void fillGreenColor(String excelFile, String excelSheet, int rowNum, int colNum) throws IOException
	{
		fileInputStream = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(excelSheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		
		cellStyle = workbook.createCellStyle();
		
		cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(cellStyle);
		fileOutputStream = new FileOutputStream(excelFile);
		workbook.write(fileOutputStream);
		workbook.close();
		fileInputStream.close();
		fileOutputStream.close();
	}
	
	public static void fillRedColor(String excelFile, String excelSheet, int rowNum, int colNum) throws IOException
	{
		fileInputStream = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(excelSheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		
		cellStyle = workbook.createCellStyle();
		
		cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(cellStyle);
		fileOutputStream = new FileOutputStream(excelFile);
		workbook.write(fileOutputStream);
		workbook.close();
		fileInputStream.close();
		fileOutputStream.close();
	}
}
