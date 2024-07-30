package com.comcast.CRM.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationinformationpage {
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerinfo;
public Organizationinformationpage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public String getHeaderinfo() {
	String headerinform = headerinfo.getText();
	return headerinform;
	 }

}
