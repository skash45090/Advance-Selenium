package vTiger.Practice;

import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;

public class GenericMethodsPractice 
{
	public static void main(String[] args) throws Exception 
	{
		JavaLibrary jlib=new JavaLibrary();
		PropertyFileLibrary plib=new PropertyFileLibrary();
		ExcelFileLibrary elib=new ExcelFileLibrary();
		
		String date = jlib.getSystemDate();
		System.out.println(date);
		String date1 = jlib.getSystemDateInFormat();
		System.out.println(date1);
		
		String value = plib.readDataFromPropertyFile("browser");
		System.out.println(value);
		String value1 = plib.readDataFromPropertyFile("username");
		System.out.println(value1);
		
		String val = elib.readDataFromExcel("admin", 2, 1);
		System.out.println(val);
		
		int row = elib.getRowCount("Contacts");
		System.out.println(row);
		elib.writeDataIntoExcel("Organization", 7, 6, "shubham");
	}
}
