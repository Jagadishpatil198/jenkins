package com.comcast.CRM.ContactTest;
/**
 * @author jagadish
  
 
 
 */

import org.junit.Test;
import org.openqa.selenium.UsernameAndPassword;

import com.comcast.CRM.objectrepository.LoginPage;

import comcast.crm.basepagetest.Basepage;

public class SearchContactTest extends Basepage{
	/*
	 * scnario : login()==> navigatecontact==>createcontact()==>verify
	 */
@org.testng.annotations.Test
public void searchContactTest()
{
	/*step 1: login to appln */
	LoginPage lp=new LoginPage(driver);
	//lp.login();
}
}
