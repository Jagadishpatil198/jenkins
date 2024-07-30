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
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrganizationwithnumber {
	public static void main(String[] args) throws Exception {
		//get the physical representation of file
		FileInputStream fis=new FileInputStream("C:\\Users\\Win10\\OneDrive\\Desktop\\datacommon.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		
		//To generate the random number 
		Random random=new Random();
		int randomint = random.nextInt();
		
		//get the testdata from excel
		
		FileInputStream file=new FileInputStream("C:\\Users\\Win10\\OneDrive\\Desktop\\CRM Appln testcase generic utility\\Book2.xlsx");
		Workbook wb = WorkbookFactory.create(file);
	           Sheet sh = wb.getSheet("Sheet1");
	           Row row = sh.getRow(7);
	           String orgname = row.getCell(2).toString() + randomint;
              
               String phonenumber = row.getCell(3).toString();
	           
	           WebDriver driver=null;
	           if(BROWSER.equals("chrome"))
	           {
	        	   driver= new ChromeDriver();
	           }
	           else if(BROWSER.equals("firefox"))
	           {
	        	   driver= new FirefoxDriver();
	           }else
	           {
	        	   driver=new ChromeDriver();
	           }
	           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 		  driver.get(URL);
	 		  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	 		  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	 		  driver.findElement(By.id("submitButton")).click();
	 		  //step 2: navigate to organization module
	 		  driver.findElement(By.linkText("Organizations")).click();
	 		  
	 		  // step3: click on "create organization button
	 		  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	 		  
	 		//  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	 		 driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
	 		 driver.findElement(By.id("phone")).sendKeys(phonenumber);
			  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
               String phoneinfo = driver.findElement(By.id("mouseArea_Phone")).getText();
               if(phoneinfo.contains(phonenumber))
               {
            	   System.out.println(phoneinfo+ "is available");
               }else
               {
            	   System.out.println(phoneinfo+ "is not available");

               }
	 		 
	}



}
