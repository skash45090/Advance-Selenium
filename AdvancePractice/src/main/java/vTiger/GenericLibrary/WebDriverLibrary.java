package vTiger.GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverLibrary 
{
	public void maximiseWindow(WebDriver driver)
	{
	driver.manage().window().maximize();
	}	
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitAndClickElement(WebElement element) throws InterruptedException
	{
		int count=0;
		if(count<10)
		{
			try
			{
				element.click();
				//break;
			}
			catch(Exception e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	// this will handle DropDown in WebPage
	public void handleDropdown(WebElement element, int text)
	{
		Select s=new Select(element);
		s.selectByIndex(text);
	}
	public void handleDropdown(WebElement element, String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	public void handleDropdown(String text, WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	// Mouse Hover
	public void mouseHoverOn(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	// Right Click on the WebPage
	public void rightClickOn(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	// Right click on the particular WebElement
	public void rightClickOn(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	//Double Click
	public void doubleClick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	// Double Click on particular webElement
	public void doubleClickOn(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	//drag and drop
	public void dragAndDrops(WebDriver driver,WebElement srcElement,WebElement dstElement)
	{
		Actions acts=new Actions(driver);
		acts.dragAndDrop(srcElement, dstElement).perform();
	}
	//mouse hover using offset value of x and y
	public void mouseHoverOn(WebDriver driver, int xoff, int yoff)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(xoff, yoff);
	}
	// switch frame action 
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	// this method will switch to frame based on name or id
	public void switchToFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId); 
	}
	public void switchToFrame(WebDriver driver,WebElement element)	
	{
		driver.switchTo().frame(element);
	}
	//this method will switch from current frame to immediate parent
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	// this method will switch back or default frame 
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	// this method will click on accept or cancel in alert pop up
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void dismisAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	//this method will return the text of alert pop up to the caller
	public String getAlertText(WebDriver driver)
	{
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}
	// this method will press the enter key
	public void pressEnter() throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);		
}
	public void switchToWindow(WebDriver driver ,String partialWindowTitle)
	{
		// get all the window handles
		Set<String> windowIds = driver.getWindowHandles();
		//iterate through all the windows id-- similar to for each loop
		Iterator<String> it = windowIds.iterator();
		// navigate to each window and check the title
		while(it.hasNext())
		{
			String winID = it.next();
			
			String currentTitle = driver.switchTo().window(winID).getTitle();
			// compare current title with partial title
			if(currentTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
