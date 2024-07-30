package com.comcast.CRM.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaignpage {
	public Campaignpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
@FindBy(linkText = "Campaigns")
 private WebElement compaignlink;
@FindBy(xpath =  "//img[@title='Create Campaign...']")
private WebElement createcampaignicon;
@FindBy(name =    "campaignname")
private WebElement camppaignnameedit;
@FindBy(xpath =  "//img[@title='Select']")
private WebElement producticon;
@FindBy(xpath =  "//input[@title='Save [Alt+S]']")
private WebElement savebutton;
public WebElement getCompaignlink() {
	return compaignlink;
}
public WebElement getCreatecampaignicon() {
	return createcampaignicon;
}
public WebElement getCamppaignnameedit() {
	return camppaignnameedit;
}
public WebElement getProducticon() {
	return producticon;
}
public WebElement getSavebutton() {
	return savebutton;
}

}
