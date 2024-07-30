package practice_dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DataProvider {
	
	@Test(dataProvider = "passdata")
	public void searchforMultipledata(String brandname, String phonename)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname);
		driver.findElement(By.id("nav-search-submit-button")).click();
		//String price = driver.findElement(By.xpath("(//span[text()='"+phonename+"']/ancestor::div[*]/div[@class='puisg-col-inner']/descendant::span[@class='a-offscreen'])[1]")).getText();
		System.out.println( driver.findElement(By.xpath("(//span[text()='"+phonename+"']/../../../..//span[@class='a-price-whole'])[1]")).getText());
				
   
		//System.out.println(phonename+"phone price is "+price);
	
	}
	
	
	@org.testng.annotations.DataProvider
	public Object[][] passdata()
	{
		Object[][] objarr=new Object[2][2];
		objarr[0][0]="iphone13";
		objarr[0][1]="Apple iPhone 13 (128GB) - Midnight";
		objarr[1][0]="iphone15";
		objarr[1][1]="Apple iPhone 15 (128 GB) - Black";
		return objarr;
	}
	//span[text()='Apple iPhone 15 (128 GB) - Black']/ancestor::div[@class='puisg-col-inner']/descendant::span[@class='a-offscreen']
	@org.testng.annotations.DataProvider
	public Object[][] passdata1()
	{
		Object[][] objarr=new Object[2][2];
		objarr[0][0]="iphone13";
		objarr[0][1]="Apple iPhone 13 (128GB) - Midnight";
		objarr[1][0]="iphone15";
		objarr[1][1]="Apple iPhone 15 (128 GB) - Black";
		return objarr;
	}

	

}
