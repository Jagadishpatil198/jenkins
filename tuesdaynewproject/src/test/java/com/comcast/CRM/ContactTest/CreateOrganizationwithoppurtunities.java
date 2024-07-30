package com.comcast.CRM.ContactTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
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

public class CreateOrganizationwithoppurtunities {
	public static void main(String[] args) throws Exception {
		WebDriver driver;
	//fetching the data from the property file
		FileInputStream fis=new FileInputStream("C:\\Users\\Win10\\OneDrive\\Desktop\\commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		  String URL = pobj.getProperty("url");
		  String USERNAME = pobj.getProperty("username");
		  String PASSWORD = pobj.getProperty("password");
		  //generate random number
		  Random rn=new Random();
		  int randomint = rn.nextInt(1000);
		  
		  
		 //fetch the data from the excel data
		  FileInputStream file=new FileInputStream("C:\\Users\\Win10\\OneDrive\\Desktop\\CRM Appln testcase generic utility\\Book2.xlsx");
		 Workbook wb = WorkbookFactory.create(file);
          Sheet sh = wb.getSheet("Sheet2");
		        Row row = sh.getRow(4);
		      String orgname = row.getCell(2).toString() + randomint;
		       String conlastname = row.getCell(3).toString() +randomint;
		      String industry = row.getCell(4).toString();
		      String type = row.getCell(5).toString();
		   //  double phonenumber = row.getCell(6).getNumericCellValue();
		    long phonenumber = (long) row.getCell(6).getNumericCellValue();
		  String phoneno = String.valueOf(phonenumber);
		     //long i =(long) phonenumber;
		  // another method convert by using parserint
		String oppurtunityname = row.getCell(7).toString() + randomint;
		String orgselect = row.getCell(8).toString();
		 String campaign = row.getCell(2).toString() + randomint;
		 String productname = row.getCell(3).toString() + randomint;
		 Sheet sh3 = wb.getSheet("Sheet3");
		 Row row2 = sh3.getRow(2);
		 String firstnametype = row2.getCell(0).toString();
		 String leadfirstname = row2.getCell(1).toString()+ randomint;
		 String leadlastname = row2.getCell(2).toString()+ randomint;
		 String leadcompanyname = row2.getCell(3).toString()+ randomint;
		 String leadsourcedropdown= row2.getCell(4).toString();
		 String leadindustrydropdown = row2.getCell(5).toString();
		 long leadphone =(long) row2.getCell(6).getNumericCellValue();
		String leadphonenumber = String.valueOf(leadphone);
		 String leadstatusdropdown = row2.getCell(7).toString();
		// String monandyr=row2.getCell(8).toString();
		// String monandyr="July, 2024";
		 String monandyr="July, 2024";
	//	 int randomday = rn.nextInt(30);
		 int randomday =28;






		  
        
		     if(BROWSER=="chrome")
          {
        	  driver=new ChromeDriver();
        	  
          }else if(BROWSER=="firefox")
          {
        	  driver= new FirefoxDriver();
          }else if(BROWSER=="edge")
          {
        	  driver=new EdgeDriver();
          }else
          {
        	  driver=new ChromeDriver();
          }
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          driver.get(URL);
          driver.manage().window().maximize();
          driver.findElement(By.name("user_name")).sendKeys(USERNAME);
       //   driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
       //   driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
          driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
          driver.findElement(By.id("submitButton")).click();
          //create one product
		  driver.findElement(By.linkText("Products")).click();
		  driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		  driver.findElement(By.name("productname")).sendKeys(productname);
		 WebElement dd = driver.findElement(By.name("productcategory"));
		 Select s=new Select(dd);
		 s.selectByValue("Software");
		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	   Actions act=new Actions(driver);
		  WebElement moreele = driver.findElement(By.xpath("//a[text()='More']"));
		   act.moveToElement(moreele).perform();
		   driver.findElement(By.linkText("Campaigns")).click();
		   driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		   driver.findElement(By.name("campaignname")).sendKeys(campaign);
		   driver.findElement(By.xpath("//img[@title='Select']")).click();
		   Set<String> set = driver.getWindowHandles();
		  ArrayList<String> arr=new ArrayList<String>(set);
		  driver.switchTo().window(arr.get(1));
		  
		   driver.findElement(By.id("search_txt")).sendKeys(productname);
		   driver.findElement(By.name("search")).click();
		   driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();

             driver.switchTo().window(arr.get(0));
  		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
          
          //click on organization and create one organization
          
          driver.findElement(By.linkText("Organizations")).click();
          driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
          driver.findElement(By.name("accountname")).sendKeys(orgname);
          
          //select the industry dropdown
          WebElement industrydd = driver.findElement(By.name("industry"));
          Select sindustry=new Select(industrydd);
          sindustry.selectByVisibleText(industry);
          
          //select type of organization dropdown
          WebElement typedd = driver.findElement(By.name("accounttype"));
          Select typeorg=new Select(typedd);
          typeorg.selectByVisibleText(type);
          driver.findElement(By.id("phone")).sendKeys(phoneno);
          driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
          Thread.sleep(2000);
          //navigate to contact module
         // driver.findElement(By.xpath("//a[@href='index.php?module=Home&action=index&parenttab=My Home Page']")).click();
          
         driver.findElement(By.partialLinkText("Contacts")).click();
          
         // driver.findElement(RelativeLocator.with(By.tagName("//a")).toLeftOf(By.linkText("Organizations"))).click();
          //   driver.findElement(By.xpath("//a[@href='href=index.php?module=Contacts&action=index']")).click();
          driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
          driver.findElement(By.name("lastname")).sendKeys(conlastname);
          
          driver.findElement(By.xpath("//img[@title='Select']")).click();
          // switch to child window
          Set<String> set3= driver.getWindowHandles();
          ArrayList<String> arr3=new ArrayList<String>(set3);
          driver.switchTo().window(arr3.get(1));
          
          
          driver.findElement(By.name("search_text")).sendKeys(orgname);
          driver.findElement(By.name("search")).click();
          driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
          //switch to parent window
          driver.switchTo().window(arr.get(0));
          driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
          Thread.sleep(2000);
          // navigate to oppurtunities module
          driver.findElement(By.linkText("Opportunities")).click();
          driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
          
          driver.findElement(By.name("potentialname")).sendKeys(oppurtunityname);
          // select organization in the dropdown
          WebElement orgdd = driver.findElement(By.id("related_to_type"));
          Select    org=new Select(orgdd);
          org.selectByVisibleText(orgselect);
          
          driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
          
          //switch to child window
         Set<String> set1 = driver.getWindowHandles();
         ArrayList<String> arr1=new ArrayList<String>(set1);
         driver.switchTo().window(arr1.get(1));
         driver.findElement(By.name("search_text")).sendKeys(orgname);
         driver.findElement(By.name("search")).click();
         driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
         //switch to parent window
         driver.switchTo().window(arr1.get(0));
         driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
         Set<String> set2 = driver.getWindowHandles();
         ArrayList<String> arr2=new ArrayList<String>(set2);
         driver.switchTo().window(arr2.get(1));
         driver.findElement(By.name("search_text")).sendKeys(campaign);
         driver.findElement(By.name("search")).click();
         driver.findElement(By.xpath("//a[text()='"+campaign+"']")).click();
         
         //switch to parent window
         driver.switchTo().window(arr2.get(0));
         driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
            Thread.sleep(2000);
         
           // navigate to lead module  
          driver.findElement(By.xpath("//a[@href='index.php?module=Leads&action=index']")).click();
          driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
          
          //handle first name type  dropdown
       WebElement fntype = driver.findElement(By.name("salutationtype"));
       Select    selfntype=new Select(fntype);
       selfntype.selectByVisibleText(firstnametype);
       driver.findElement(By.name("firstname")).sendKeys(leadfirstname);
       driver.findElement(By.name("lastname")).sendKeys(leadlastname);
       driver.findElement(By.name("company")).sendKeys(leadcompanyname);
       
       // select lead source from the dropdown
       WebElement leadsourceddele = driver.findElement(By.name("leadsource"));
       Select leadsourcedd=new Select(leadsourceddele);
              leadsourcedd.selectByVisibleText(leadsourcedropdown);
              
              // select lead industry from the dropdown
             WebElement industryddele = driver.findElement(By.name("industry"));
          Select industryddeleadres=new Select(industryddele);
          industryddeleadres.selectByVisibleText(leadindustrydropdown);
          driver.findElement(By.name("phone")).sendKeys(leadphonenumber);
          // select lead status from the dropdown
          WebElement leadstausdd = driver.findElement(By.name("leadstatus"));
          Select leadstausddele=new Select(leadstausdd);
          leadstausddele.selectByVisibleText(leadstatusdropdown);
          driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
          Thread.sleep(2000);
          driver.findElement(By.linkText("Convert Lead")).click();
          driver.findElement(By.id("select_potential")).click();
          // handle the calendar dropdown and pass the data from excel
        driver.findElement(By.id("jscal_trigger_closedate")).click();
        driver.findElement(By.xpath("//td[text()='"+monandyr+"']/ancestor::table/descendant::tbody/descendant::td[text()='"+randomday+"']")).click();
     
         
          
          Thread.sleep(2000);
          driver.findElement(By.name("Save")).click();
          Thread.sleep(2000);
      WebElement sign = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));  
      Actions act1=new Actions(driver);
      act1.moveToElement(sign).perform();
      driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}        
}
