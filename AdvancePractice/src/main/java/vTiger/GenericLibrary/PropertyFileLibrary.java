package vTiger.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileLibrary 
{
	public String readDataFromPropertyFile(String key) throws IOException 
	{
	FileInputStream file=new FileInputStream(IConstantLibrary.propertyfilepath);
	Properties pros=new Properties();
	pros.load(file);
	String value = pros.getProperty(key);
	return value;
    }
}