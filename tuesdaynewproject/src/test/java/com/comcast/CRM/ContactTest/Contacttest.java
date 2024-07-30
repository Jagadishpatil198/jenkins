package com.comcast.CRM.ContactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.CRM.generic.fileutility.Excelutility;
import com.comcast.CRM.generic.fileutility.Fileutility;
import com.comcast.CRM.generic.webdriverutility.Javautility;
import com.comcast.CRM.generic.webdriverutility.Webdriverutility;
import com.comcast.CRM.objectrepository.Commonpopupwindowpage;
import com.comcast.CRM.objectrepository.CreatenewContactpage;
import com.comcast.CRM.objectrepository.Homepage;
import com.comcast.CRM.objectrepository.Organizationinformationpage;
import com.comcast.CRM.objectrepository.Organizationpage;

import comcast.crm.basepagetest.Basepage;

public class Contacttest extends Basepage {
	
	@Test(groups = "RegressionTest")
	public  void createcontactwithorg() throws Exception 
	{
		String orgname1;
//	      Javautility jlib=new Javautility();
//			int randomint = jlib.getrandomnumber();
			
			//read test script data from excel file
			orgname1=excellib.getdatafromexcel("Sheet1", 16, 2)+ randomint;
			 String lastname = excellib.getdatafromexcel("Sheet1", 16, 3);
			 
			 //step 2: navigate to organization module
			

			  HP.getOrganizationslink().click();
			 
			  // step3: click on "create organization button
			  Organizationpage orgpage=new Organizationpage(driver);
			  orgpage.getOrganizationbutton().click();
			  
			  // enter all the details and create organization
			  orgpage.getOrganizationname().sendKeys(orgname1);
			  orgpage.getSavebutton().click();
			 
			  Organizationinformationpage organizationinfopage=new Organizationinformationpage(driver);
			  String headerinfo = organizationinfopage.getHeaderinfo();
			   if(headerinfo.contains(orgname1))
			   {
				   System.out.println(orgname1+"is created==Pass");
			   }else
			   {
				   System.out.println(orgname1+"is created==fail");
			   }
			  
			   // step5 : navigate to contact module
			HP.getContactslink().click();
		 		
		 	createcontact.getCreatecontactbtn().click();
		 	createcontact.getLastname().sendKeys(lastname);
		 		createcontact.organizationsbutton().click();
		 		 Commonpopupwindowpage cwd=new Commonpopupwindowpage(driver);
		 	
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
		 		 cwd.getSearchtextedit().sendKeys(orgname1);
		 		 cwd.getSearchbutton().click();
		 	     driver.findElement(By.xpath("//a[text()='"+orgname1+"']"));
		 		
		 	     // switch to parent window
		 		Set<String> set1 = driver.getWindowHandles();
		 		 Iterator<String> iter1 = set1.iterator();
		 		 while(iter1.hasNext())
		 		 {
		 			String windowid1 = iter1.next();
		 			driver.switchTo().window(windowid1);
		 			String actualurl1 = driver.getCurrentUrl();
		 			if(actualurl1.contains("Contacts&action"))
		 			{
		 				break;
		 			}

		 		 }
		 		createcontact.getSavebtn().click();
		 		
		 		// verify contact last name
		 		  String lastnameinfo = driver.findElement(By.id("dtlview_Last Name")).getText();
		 		  if(lastnameinfo.equals(lastname))
		 		  {
		 			  System.out.println(lastnameinfo + " is verified");
		 		  }else
		 		  {
		 			  System.out.println(lastnameinfo + " is not verified");
		 		  }
		 		 
		 		  // verify contact information
		 		  String contactinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 		  if(contactinfo.contains(lastname))
		 		  {
		 			  System.out.println(contactinfo + " is verified");
		 		  }else
		 		  {
		 			  
		 			  System.out.println(contactinfo + " is not verified");

		 		  }
		 		 System.out.println(Thread.currentThread().getId());  
	 		 }
	@Test(groups = "RegressionTest")
	public void CreateContactwithSupportdate() throws Exception
	{    
		//get the testdata from excel
		  String lastname = excellib.getdatafromexcel("Sheet1", 13, 2).toString() + randomint;
				
		 // navigate to contact module
		 HP.getContactslink().click();
			   
			createcontact.getCreatecontactbtn().click(); 		
		
			 		  
			 		Webdriverutility wlib=new Webdriverutility(driver);
		
			 	
			 		String startdate = wlib.startdate();
			 		
			 	
			 		String enddate = wlib.enddate();
			 		
			 		System.out.println(startdate+"is"+enddate);
			 createcontact.getLastname().sendKeys(lastname);
			 System.out.println("addd");
			createcontact.getStartdate().clear();
			 System.out.println("hii addd");

			 createcontact.getStartdate().sendKeys(startdate);
			 createcontact.getEnddate().clear();
			 createcontact.getEnddate().sendKeys(enddate);
			 createcontact.getSavebtn().click();
		 		 
			 		  
			 System.out.println(Thread.currentThread().getId());	  
			}


	}


