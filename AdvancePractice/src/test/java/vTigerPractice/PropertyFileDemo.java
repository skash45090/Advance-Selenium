package vTigerPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileDemo 
{
	static public void main(String[] args) throws IOException 
	{
		FileInputStream file=new FileInputStream(".\\src\\test\\resources\\data.properties");
		Properties pro=new Properties();
		pro.load(file);
		
		String ele = pro.getProperty("browser");
		System.out.println(ele);
	}
}
