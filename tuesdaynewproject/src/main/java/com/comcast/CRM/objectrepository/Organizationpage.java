package com.comcast.CRM.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationpage {
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement organizationbutton;
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement organizationname;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	@FindBy(name = "industry")
	private WebElement industrydropdown;
	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement typedropdown;
	@FindBy(id =  "mouseArea_Industry")
	private WebElement industryinfo;
	public WebElement getIndustryinfo() {
		return industryinfo;
	}
	public WebElement getTypedropdown() {
		return typedropdown;
	}
	public WebElement getIndustrydropdown() {
		return industrydropdown;
	}
	public Organizationpage(WebDriver driver)
{
   PageFactory.initElements(driver, this);		
}
	public WebElement getOrganizationbutton() {
		return organizationbutton;
	}
	public WebElement getOrganizationname() {
		return organizationname;
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
}
