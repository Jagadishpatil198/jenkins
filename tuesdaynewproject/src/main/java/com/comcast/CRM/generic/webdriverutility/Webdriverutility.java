package com.comcast.CRM.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriverutility {
	WebDriver driver=null;
	SimpleDateFormat sim=null;

  public Webdriverutility(WebDriver driver)
  {
	  this.driver=driver;
  }
	public void waitforpagetoload()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitforElementpresent(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void switchnewbrowserTab( String partialurl)
	{
		 Set<String> set = driver.getWindowHandles();
 		 Iterator<String> iter = set.iterator();
 		 while(iter.hasNext())
 		 {
 			String windowid = iter.next();
 			driver.switchTo().window(windowid);
 			String actualurl = driver.getCurrentUrl();
 			if(actualurl.contains(partialurl))
 			{
 				break;
 			}
 				
	}
    }
	public void switchnewBrowserTab( String partialtitle)
	{
		 Set<String> set = driver.getWindowHandles();
 		 Iterator<String> iter = set.iterator();
 		 while(iter.hasNext())
 		 {
 			String windowid = iter.next();
 			driver.switchTo().window(windowid);
 			String actualurl = driver.getCurrentUrl();
 			if(actualurl.contains(partialtitle))
 			{
 				break;
 			}
 		 }
	}
	public void Switchtoframe( int index)
	{
		driver.switchTo().frame(index);
	}
	public void Switchtoframe( String nameid)
	{
		driver.switchTo().frame(nameid);
	}
	public void Switchtoframe( WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void Switchtoframedefaultcontent()
	{
		driver.switchTo().defaultContent();
	}
	public void Switchtoframedparent()
	{
		driver.switchTo().parentFrame();
	}
	public void SwitchtoAlertAccept()
	{
		driver.switchTo().alert().accept();
	}
	public void SwitchtoAlertcancel()
	{
		driver.switchTo().alert().dismiss();
	}
	public void selectvisibletext(WebElement element, String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public void selectbyvalue(WebElement element, String text)
	{
		Select sel=new Select(element);
		sel.selectByValue(text);
	}
	public void movetoelement( WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void doubleclick( WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void draganddrop( WebElement src, WebElement dest)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, dest).perform();
		}
	public void Scrolltoelement( WebElement element)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();
		}
	public void Rightclick( WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
		}
	public void sendkeys( String value)
	{
		Actions act=new Actions(driver);
		act.sendKeys(value).perform();
		
		}
	public void javascriptexecutor(WebDriver driver, String value,String ID)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById("+ID+").value='"+value+";");
	}
	public String startdate()
	{
		java.util.Date dateobj=new java.util.Date();

	      sim=new SimpleDateFormat("yyyy-MM-dd");
 		String startdate = sim.format(dateobj);
 		return startdate;
	}
	public String enddate()
	{
 		//System.out.println(actualdate);
 		Calendar cal = sim.getCalendar();
 		cal.add(Calendar.DAY_OF_MONTH, 30);
 		String enddate = sim.format(cal.getTime());
 		return enddate;
	}

}