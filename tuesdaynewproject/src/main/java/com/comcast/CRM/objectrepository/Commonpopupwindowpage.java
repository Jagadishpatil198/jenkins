package com.comcast.CRM.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Commonpopupwindowpage {
	@FindBy(name = "search_text")
	private WebElement searchtextedit;
	@FindBy(name = "search")
	private WebElement searchbutton;
	public Commonpopupwindowpage(WebDriver driver)
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
