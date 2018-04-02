package com.crm.qa.testcases;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class loginPageTest extends TestBase{
	
	
	public loginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws MalformedURLException 
	{
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test()
	public void loginPageTitleTest()
	{
		String title = loginpage.validateLoginpageTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test()
	public void CRMImageTest()
	{
		Assert.assertTrue(loginpage.ValidateCRMImage());
	}
	
	@Test()
	public void loginTest()
	{
		
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
