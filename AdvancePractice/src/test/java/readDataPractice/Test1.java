package readDataPractice;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 
{
	public static void main(String[] args) throws Exception 
	{
		
		//File file=new File(".\\SHUBHAM\\ReadData.xlsx");
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\ReadData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		
		String url=workbook.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();	
		String username=workbook.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue();
		String password=workbook.getSheet("Sheet1").getRow(3).getCell(1).getStringCellValue();
		String OrganizationName=workbook.getSheet("Sheet1").getRow(4).getCell(1).getStringCellValue();		
		
		WebDriver driver=new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//td//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")).click();
		driver.findElement(By.name("accountname")).sendKeys(OrganizationName);
		driver.close();
		
	}
}
