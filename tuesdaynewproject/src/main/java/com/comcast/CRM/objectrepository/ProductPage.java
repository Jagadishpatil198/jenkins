package com.comcast.CRM.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class ProductPage {
@FindBy(xpath = "//img[@title='Create Product...']")
private WebElement createproducticon;
@FindBy(name = "productname")
private WebElement productnameedit;
@FindBy(name = "productcategory")
private WebElement productcategorydropdown;
@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement savebtn;
public ProductPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getCreateproducticon() {
	return createproducticon;
}
public WebElement getProductnameedit() {
	return productnameedit;
}
public WebElement getProductcategorydropdown() {
	return productcategorydropdown;
}
public WebElement getSavebtn() {
	return savebtn;
}

}
