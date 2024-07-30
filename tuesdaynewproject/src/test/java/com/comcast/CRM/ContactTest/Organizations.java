package com.comcast.CRM.ContactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.comcast.CRM.generic.fileutility.Excelutility;
import com.comcast.CRM.generic.fileutility.Fileutility;
import com.comcast.CRM.generic.webdriverutility.Javautility;
import com.comcast.CRM.generic.webdriverutility.Webdriverutility;
import com.comcast.CRM.objectrepository.Contactinfopage;
import com.comcast.CRM.objectrepository.CreatenewContactpage;
import com.comcast.CRM.objectrepository.LoginPage;
import com.comcast.CRM.objectrepository.Organizationpage;

import comcast.crm.basepagetest.Basepage;

public class Organizations extends Basepage {
	@Test(groups = "SmokeTest")
	public void createorgtest() throws Exception {
		
	Reporter.log("Application launched", true);
	
	//get the testdata from excel
		String lastname = excellib.getdatafromexcel("Sheet1", 10, 2).toString()+randomint;
          
           
           
         
 		HP.getContactslink().click();
 	//	  driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
 		 Contactinfopage cip=new Contactinfopage(driver);
 		 cip.getCreatecontactbtn().click();
 		CreatenewContactpage cnc=new CreatenewContactpage(driver);
 		String val=cnc.Createconwithlastname(lastname);
             if(val.contains(lastname))
             {
            	 System.out.println(val+ "is present");
            	 
             }else
             {
            	 System.out.println(val+ "is not present");

             }
           String actualname = cip.getactualname();
             if(actualname.trim().equals(lastname))
             {
            	 System.out.println(actualname + "is present");
            	 
             }else
             {
            	 System.out.println(actualname + "is not present");

             }
             System.out.println(Thread.currentThread().getId());
}
	@Test(groups = "SmokeTest")
	public void Oranizationdelete() throws Exception {
	
		 String campaign = excellib.getdatafromexcel("Sheet2", 1, 2).toString()+randomint;
		 String productname =excellib.getdatafromexcel("Sheet2", 1, 3).toString()+randomint;
		
		
		
		
		
		
		  //delete all the organizations
		 HP.getOrganizationslink().click();
		//  driver.findElement(By.linkText("Organizations")).click();
		//List<WebElement> deletorg = driver.findElements(By.name("selectall"));
		List<WebElement> deletorg1 = driver.findElements(By.xpath("//a[text()='Organization No']"));
		
		ArrayList<WebElement> arr=new ArrayList<WebElement>(deletorg1);
		
	
		for(WebElement delete:deletorg1)	
			
		{
			
			delete.click();
			//for(WebElement ar:arr)
//			{
//			  String arr1 = ar.getText();
//			System.out.println(arr1);
//			if(arr1.equals("ACC5 "))
//			{
			driver.findElement(By.xpath("//a[text()='del']")).click();
			Alert al = driver.switchTo().alert();
			al.accept();
			//Thread.sleep(2000);
			//break;
			}
	}

	@Test(groups = "RegressionTest")
	public void CreateOrganizationindustry() throws Exception
	{
	
		//get the testdata from excel
		
	           String orgname = 	excellib.getdatafromexcel("Sheet1", 4, 2).toString()+randomint;
               String industry =excellib.getdatafromexcel("Sheet1", 4, 3).toString();
               String type =excellib.getdatafromexcel("Sheet1", 4, 4).toString();
               System.out.println(industry);
	           
	         
	 		  //step 2: navigate to organization module
               HP.getOrganizationslink().click();
	 		//  driver.findElement(By.linkText("Organizations")).click();
	 		  
	 		  // step3: click on "create organization button
               Organizationpage organizationpage=new Organizationpage(driver);
               organizationpage.getOrganizationbutton().click();
	 		 // driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	 		  
	 		 // driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			  
			  // enter all the details and create organization
               organizationpage.getOrganizationname().sendKeys(orgname);
			  // driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
              // WebElement industrydd = organizationpage.getIndustrydropdown();
               WebElement industrydd = driver.findElement(By.name("industry"));
			 wlib.selectvisibletext(industrydd, industry);
//               Select industryele=new Select(industrydd);
//			   industryele.selectByVisibleText(industry);
			 // WebElement typedd = driver.findElement(By.xpath("//select[@name='accounttype']"));
		WebElement typedd = organizationpage.getTypedropdown();
			 wlib.selectvisibletext(typedd, type);
//		Select typele=new Select(typedd);
//			  typele.selectByVisibleText(type);
			organizationpage.getSavebutton().click();
			// driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			  Thread.sleep(2000);
			String  industryinfo= organizationpage.getIndustryinfo().getText();
			 // String  industryinfo = driver.findElement(By.id("mouseArea_Industry")).getText();
			  
			  //verify industry info
			  if(industryinfo.equals(industry))
			  {
				  System.out.println(industry+ "is visible");
			  }else
			  {
				  System.out.println(industry+ "is not visible");
			  }
			  // verify  type info
			  String typeinfo = driver.findElement(By.id("mouseArea_Type")).getText();
			  if(typeinfo.equals(type))
			  {
				  System.out.println(typeinfo+ "is visible");
			  }else
			  {
				  System.out.println(typeinfo+ "is not visible");
			  }
			  
			  
			  
			  System.out.println(Thread.currentThread().getId());

	}
	}
	

