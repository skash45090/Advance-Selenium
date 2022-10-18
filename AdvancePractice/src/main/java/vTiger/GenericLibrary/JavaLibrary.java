package vTiger.GenericLibrary;


import java.util.Date;
import java.util.Random;

public class JavaLibrary 
{
	public int getRandomNumber()
	{
		Random random=new Random();
		int value=random.nextInt(500);
		return value;
	}
	public String getSystemDate()
	{
		Date d=new Date();
		String date=d.toString();
		return date;
	}
	public String getSystemDateInFormat()
	{
		Date d=new Date();
		String[] dateArray = d.toString().split("");
		String month = dateArray[1];
		String date = dateArray[2];
		String year = dateArray[5];
		String time = dateArray[3].replace(":","-");
		
		String dateInFormat = date+"-"+month+"-"+year+"-"+time;
		return dateInFormat;
	}
	
}
