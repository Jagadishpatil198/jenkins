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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationwithindustry {
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
	           Row row = sh.getRow(4);
	           String orgname = row.getCell(2).toString() + randomint;
               String industry = row.getCell(3).toString();
               String type = row.getCell(4).toString();
	           
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
	 		  
	 		  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			  
			  // enter all the details and create organization
			   driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
			  WebElement industrydd = driver.findElement(By.name("industry"));
			   Select industryele=new Select(industrydd);
			   industryele.selectByVisibleText(industry);
			  WebElement typedd = driver.findElement(By.xpath("//select[@name='accounttype']"));
			  Select typele=new Select(typedd);
			  typele.selectByVisibleText(type);
			  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			  Thread.sleep(2000);
			  String  industryinfo = driver.findElement(By.id("mouseArea_Industry")).getText();
			  
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
			  
			  
			  
			  

	}


}
