package com.comcast.CRM.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.CRM.generic.webdriverutility.Webdriverutility;

public class Homepage {
	@FindBy(linkText = "Calendar")
	private WebElement calendarlink;
	@FindBy(linkText = "Leads")
	private WebElement Leadslink;
	@FindBy(linkText = "Organizations")
	private WebElement Organizationslink;
	@FindBy(linkText = "Contacts")
	private WebElement Contactslink;
	@FindBy(linkText = "Opportunities")
	private WebElement Opportunitieslink;
	@FindBy(linkText = "Products")
	private WebElement Productslink;
	@FindBy(linkText = "Documents")
	private WebElement Documentslink;
	@FindBy(xpath = "//a[text()='More']")
	private WebElement moremousehoverele;
	
	public Homepage(WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getCalendarlink() {
		return calendarlink;
	}
	public WebElement getLeadslink() {
		return Leadslink;
	}
	public WebElement getOrganizationslink() {
		return Organizationslink;
	}
	public WebElement getContactslink() {
		return Contactslink;
	}
	public WebElement getOpportunitieslink() {
		return Opportunitieslink;
	}
	public WebElement getProductslink() {
		return Productslink;
	}
	public WebElement getDocumentslink() {
		return Documentslink;
	}
	
	//business library
	public void clickOnOrgLInk(WebDriver driver)
	{
		Organizationslink.click();
	}
	public WebElement getmoremousehoverele()
	{
		return moremousehoverele;
	}
}
