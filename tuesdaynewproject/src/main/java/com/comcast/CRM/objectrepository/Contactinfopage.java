package com.comcast.CRM.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactinfopage {
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createcontactbtn;
	@FindBy(xpath = "//span[@id='dtlview_Last Name']")
	private WebElement actualname;
	
	public Contactinfopage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatecontactbtn() {
		return createcontactbtn;
	}
	
	public String getactualname() {
		String Actualname = actualname.getText();
		return Actualname;
	}
	
	
	
}
