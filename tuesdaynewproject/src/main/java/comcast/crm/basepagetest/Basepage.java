package comcast.crm.basepagetest;

import static org.testng.Assert.assertEquals;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.comcast.CRM.generic.fileutility.Excelutility;
import com.comcast.CRM.generic.fileutility.Fileutility;
import com.comcast.CRM.generic.webdriverutility.Javautility;
import com.comcast.CRM.generic.webdriverutility.Utilityobject;
import com.comcast.CRM.generic.webdriverutility.Webdriverutility;
import com.comcast.CRM.objectrepository.CreatenewContactpage;
import com.comcast.CRM.objectrepository.Homepage;

public class Basepage {
	public Fileutility filib;
String BROWSER=null;
public int randomint;
public  Webdriverutility wlib;
 public Excelutility excellib;
 public  	CreatenewContactpage createcontact;
public  Homepage  HP;
public static WebDriver sdriver=null;
public WebDriver driver=null;
@Parameters("Browser")
	@BeforeClass(groups = {"RegressionTest","SmokeTest"})
	public void openbrowser(@Optional ("firefox") String Browser ) throws Exception
	{
	//	System.out.println("Hi:"+Browser);
		 filib=new Fileutility();
		 BROWSER = filib.getdataPropertiesfile("browser");
		 //BROWSER = System.getProperty("BRowser" );

		// BROWSER=Browser;
			    if(BROWSER.equals("chrome"))
		         {
		       	  driver=new ChromeDriver();
		       	  
		         }else if(BROWSER.equals("firefox"))
		         {
		       	  driver= new FirefoxDriver();
		         }else if(BROWSER.equals("edge"))
		         {
		       	  driver=new EdgeDriver();
		         }
		         else
		         {
		        driver=new ChromeDriver();
		         }
			 //   sdriver=driver;
			    Utilityobject.setdriver(driver);
			    //System.out.println(sdriver);
			  //  assertEquals("chrome	", BROWSER, " browser is launched ");
			   // Reporter.log(BROWSER+"got launched",true);
	}
	@BeforeMethod(groups = {"RegressionTest","SmokeTest"})
	public void Login() throws Exception
	{
		String orgname1;
		
//			String URL = filib.getdataPropertiesfile("url");
//			String USERNAME = filib.getdataPropertiesfile("username");
//			String PASSWORD = filib.getdataPropertiesfile("password");
		String URL =System.getProperty("url", filib.getdataPropertiesfile("url"));
		String USERNAME = System.getProperty("username", filib.getdataPropertiesfile("username"));
		String PASSWORD = System.getProperty("password", filib.getdataPropertiesfile("password")
				
				
				
				
				);
			
			// generate the random number
			
			Javautility jlib=new Javautility();
			
			 randomint = jlib.getrandomnumber();
			
		 
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.get(URL);
         driver.manage().window().maximize();
         driver.findElement(By.name("user_name")).sendKeys(USERNAME);
         driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
         driver.findElement(By.id("submitButton")).click();
         excellib=new Excelutility();
		 	 createcontact=new CreatenewContactpage(driver);
		 	 HP = new Homepage(driver);
		 	  wlib=new Webdriverutility(driver);
	}
	@AfterMethod(groups = {"RegressionTest","SmokeTest"})
	public void logout()
	{
		   WebElement sign = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));  
		      Actions act1=new Actions(driver);
		      act1.moveToElement(sign).perform();
		      driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
	@AfterClass(groups = {"RegressionTest","SmokeTest"})
	public void closebrowser()
	{
		driver.close();
	}

}
