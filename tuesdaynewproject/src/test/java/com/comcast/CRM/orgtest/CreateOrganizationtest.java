package com.comcast.CRM.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationtest {
	public static void main(String[] args) throws Exception {
		String orgname1;
		//step 1: get the java representation object of the physical file
		FileInputStream fis=new FileInputStream("C:\\Users\\Win10\\OneDrive\\Desktop\\datacommon.properties");
		
		// step2: using properties class , load all the key
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		// generate the random number
		
		Random random=new Random();
		int randomint = random.nextInt(1000);
		//read testscript data from excel file
		FileInputStream file =new FileInputStream("C:\\Users\\Win10\\OneDrive\\Desktop\\CRM Appln testcase generic utility\\Book2.xlsx");
	      Workbook wb= WorkbookFactory.create(file);
		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(1);
		 orgname1=row.getCell(2).toString() + randomint;
		// System.out.println(orgname1);
		wb.close();
		
		
		 WebDriver driver= null;
		 if(BROWSER.equals("chrome"))
		 {
			 driver=new ChromeDriver();
		 }else if(BROWSER.equals("firefox"))
		 {
			 driver= new FirefoxDriver();
			 
		 }else if(BROWSER.equals("edge"))
		 {
			 driver=new EdgeDriver();
			 
		 }else {
			 driver=new ChromeDriver();
		 }
				
		//step 1: login to app
		 // WebDriver driver=new FirefoxDriver(); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.get(URL);
		  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		  driver.findElement(By.id("submitButton")).click();
		  //step 2: navigate to organization module
		  driver.findElement(By.linkText("Organizations")).click();
		  
		  // step3: click on "create organization button
		  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		  
		  // enter all the details and create organization
		   driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname1);
		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		   
		   //verify header msg expected result
		   Thread.sleep(20000);
		   String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		   if(headerinfo.contains(orgname1))
		   {
			   System.out.println(orgname1+"is created==Pass");
		   }else
		   {
			   System.out.println(orgname1+"is created==fail");
		   }
		 //verify header orgname info expected result
        String actualorgnameinfo = driver.findElement(By.id("mouseArea_Organization Name")).getText();
      //  System.out.println(actualorgnameinfo);
        if(actualorgnameinfo.equals(orgname1))
        {
        	 System.out.println(orgname1+ " is created==Pass");
		   }else
		   {
			   System.out.println(orgname1+"is created==fail");
		   }   
        
		   Actions act=new Actions(driver);
			//   act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")))act.perform();
			   
			 //  act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
			   
			 // driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			  driver.close();
	}



}
