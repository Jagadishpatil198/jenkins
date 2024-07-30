package com.comcast.CRM.ContactTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.cast.CRM.Listnerutility.Listnerclass;
import com.comcast.CRM.generic.fileutility.Excelutility;
import com.comcast.CRM.generic.fileutility.Fileutility;
import com.comcast.CRM.generic.webdriverutility.Javautility;
import com.comcast.CRM.generic.webdriverutility.Webdriverutility;
import com.comcast.CRM.objectrepository.Campaignpage;
import com.comcast.CRM.objectrepository.Commonpopupwindowpage;
import com.comcast.CRM.objectrepository.Homepage;
import com.comcast.CRM.objectrepository.LoginPage;
import com.comcast.CRM.objectrepository.ProductPage;
import com.comcast.CRM.objectrepository.Productpopuppage;

import comcast.crm.basepagetest.Basepage;
import junit.framework.Assert;
@Listeners(com.cast.CRM.Listnerutility.Listnerclass.class)
public class Campaign extends Basepage{
	@Test(groups = "RegressionTest")
	public void Createcampaignproduct() throws Exception {
		String orgname1;
		
			
						
			
			
			//read testscript data from excel file
		
		 String campaign = excellib.getdatafromexcel("Sheet2", 1, 2).toString()+randomint;

		 String productname = excellib.getdatafromexcel("Sheet2", 1, 3).toString()+randomint;
		// System.out.println(orgname1);
		
		
		
	
		  org.testng.Assert.assertEquals("home", "home", "failed");
		  //(Status.FAIL, "fail");
		  
		  //create one product
		 Homepage HP=new Homepage(driver);
		 HP.getProductslink().click();
		 
		 // driver.findElement(By.linkText("Products")).click();
		 ProductPage ProdPage=new ProductPage(driver);
		 ProdPage.getCreateproducticon().click();
		 ProdPage.getProductnameedit().sendKeys(productname);
		WebElement productcategorydd = ProdPage.getProductcategorydropdown();
		
		wlib.selectbyvalue(productcategorydd, "Software");
//		  driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
//		  driver.findElement(By.name("productname")).sendKeys(productname);
//		 WebElement dd = driver.findElement(By.name("productcategory"));
//		 Select s=new Select(dd);
//		 s.selectByValue("Software");
		ProdPage.getSavebtn().click();
		   //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  
		WebElement moremousehover = HP.getmoremousehoverele();
		wlib.movetoelement(moremousehover);
		
		//   act.moveToElement(moreele).perform();
//		   driver.findElement(By.linkText("Campaigns")).click();
//		   driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
//		   driver.findElement(By.name("campaignname")).sendKeys(campaign);
//		   driver.findElement(By.xpath("//img[@title='Select']")).click();
		Campaignpage campaignpage=new Campaignpage(driver);
		campaignpage.getCompaignlink().click();
		campaignpage.getCreatecampaignicon().click();
		campaignpage.getCamppaignnameedit().sendKeys(campaign);
		campaignpage.getProducticon().click();
		 // switch to child window
		 Set<String> set = driver.getWindowHandles();
		 Iterator<String> iter = set.iterator();
		 while(iter.hasNext())
		 {
			String windowid = iter.next();
			driver.switchTo().window(windowid);
			String actualurl = driver.getCurrentUrl();
			if(actualurl.contains("Accounts&action"))
			{
				break;
			}
		}
//		   Set<String> set = driver.getWindowHandles();
//		  ArrayList<String> arr=new ArrayList<String>(set);
//		  driver.switchTo().window(arr.get(1));
		  
//		   driver.findElement(By.id("search_txt")).sendKeys(productname);
//		   driver.findElement(By.name("search")).click();
		 Productpopuppage productpopuppage=new Productpopuppage(driver);
		 productpopuppage.getSearchtextedit().sendKeys(productname);
		 productpopuppage.getSearchbutton().click();
	         driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
	         Set<String> set1 = driver.getWindowHandles();
	 		 Iterator<String> iter1 = set1.iterator();
	 		 while(iter1.hasNext())
	 		 {
	 			String windowid1 = iter1.next();
	 			driver.switchTo().window(windowid1);
	 			String actualurl1 = driver.getCurrentUrl();
	 			if(actualurl1.contains("Campaigns&action"))
	 			{
	 				break;
	 			}

	 		 }
           campaignpage.getSavebutton().click();
//             driver.switchTo().window(arr.get(0));
//  		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
       
           System.out.println(Thread.currentThread().getId());
		 

	}

}
