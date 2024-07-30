package com.comcast.CRM.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpopuppage {
@FindBy(id ="search_txt" )
private WebElement searchtextedit;
@FindBy(name =  "search" )
private WebElement searchbutton;
public Productpopuppage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getSearchtextedit() {
	return searchtextedit;
}
public WebElement getSearchbutton() {
	return searchbutton;
}

}
