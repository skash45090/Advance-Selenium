package vTiger.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileLibrary 
{
	public String readDataFromExcel(String sheetName, int rowNO,int cellNo) throws Exception
	{
		FileInputStream file=new FileInputStream(IConstantLibrary.excelFilePath);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNO);
		Cell ce = rw.getCell(cellNo);
		String value = ce.getStringCellValue();
		return value;
		
		
	}
	public int getRowCount(String sheetName) throws Exception
	{
		FileInputStream file=new FileInputStream(IConstantLibrary.excelFilePath);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		return rowCount;
	}
	public void writeDataIntoExcel(String sheetname, int rowNo,int cellNo,String value) throws Exception
	{
		FileInputStream file=new FileInputStream(IConstantLibrary.excelFilePath);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet(sheetname);
		Row rw=sh.getRow(rowNo);
		Cell cel = rw.getCell(cellNo);
		cel.setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(IConstantLibrary.excelFilePath);
		wb.write(fos);
		wb.close();
	}

}
