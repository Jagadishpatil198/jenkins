package practice_dataprovider;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import comcast.crm.basepagetest.Basepage;
@Listeners(com.cast.CRM.Listnerutility.Listnerclass.class)
public class Assertion1 extends Basepage {
	@Test(groups = "RegressionTest")
	
	public void Hardassert()
	
	{
		String actualresult = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
		//SoftAssert soft=new SoftAssert();
		Assert.assertEquals(actualresult, "login" );
		Reporter.log(actualresult);
		
	}
	

}
