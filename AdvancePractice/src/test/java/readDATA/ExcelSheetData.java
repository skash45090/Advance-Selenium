package readDATA;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetData 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException, Exception 
	{
		FileInputStream file=new FileInputStream(".\\src\\test\\resources\\data.xlsx");
		Workbook wf = WorkbookFactory.create(file);
		Sheet sh = wf.getSheet("Sheet1");
		
		Row row = sh.getRow(1);
		Cell cell = row.getCell(1);
		String value = cell.getStringCellValue();
		System.out.println(value);
		
		
	}
}
