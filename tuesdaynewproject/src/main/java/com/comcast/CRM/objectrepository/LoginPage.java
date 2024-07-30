package com.comcast.CRM.objectrepository;

import org.openqa.selenium.By;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author jagadish
 * 
 * contains login page elements and business method
 */

public class LoginPage {
	@FindBy(name = "user_name")
	private WebElement useredit;
	@FindBy(name = "user_password")
	private  WebElement passedit;
	@FindBy(id = "submitButton")
	private WebElement Loginbtn;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUseredit() {
		return useredit;
	}
	public WebElement getPassedit() {
		return passedit;
	}
	public WebElement getLoginbtn() {
		return Loginbtn;
	}
	/**
	 * login to application based on username password
	 * @param username
	 * @param password
	 */
	public void login(String username, String password)
	{
		useredit.sendKeys(username);
		passedit.sendKeys(password);
		Loginbtn.click();
	}
}
