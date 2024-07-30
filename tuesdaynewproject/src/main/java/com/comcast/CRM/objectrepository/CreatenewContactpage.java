package com.comcast.CRM.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatenewContactpage {
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createcontactbtn;
	@FindBy(name = "lastname")
	private WebElement lastname;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerinfo;
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement organizationsbutton;
	@FindBy(name = "support_start_date")
	private WebElement startdate;
	@FindBy(name = "support_end_date")
	private WebElement enddate;
	
	public CreatenewContactpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreatecontactbtn() {
		return createcontactbtn;
	}
	public WebElement getLastname() {
		return lastname;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	public WebElement getHeaderinfo() {
		return headerinfo;
	}
	public String Createconwithlastname(String Lastname)
	{
		lastname.sendKeys(Lastname);
		savebtn.click();
		String headerinform = headerinfo.getText();
		return headerinform;
	}
	public WebElement organizationsbutton() {
		return organizationsbutton;
	}

	public WebElement getStartdate() {
		return startdate;
	}

	
	public WebElement getEnddate() {
		return enddate;
	}

	

}

 