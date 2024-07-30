package practice_dataprovider;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.util.RetryAnalyzerCount;

import comcast.crm.basepagetest.Basepage;
@Listeners(com.cast.CRM.Listnerutility.Listnerclass.class)
public class InvoiceTest extends Basepage{
	@org.testng.annotations.Test(retryAnalyzer = com.cast.CRM.Listnerutility.RetryListnerImp.class)
	
	public void activatesim()
	{
		System.out.println("execute createinovice test");
		String actualresult = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
		Assert.assertEquals(actualresult, "login");
		System.out.println("step1");
		
	}

}
