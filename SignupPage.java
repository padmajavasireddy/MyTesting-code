package com.crm.qa.pages;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;

public class SignupPage extends TestBase {
	
	@FindBy(id="payment_plan_id")
	WebElement Edition;
	@FindBy(name="first_name")
	WebElement FirstName;
	@FindBy(name="surname")
	WebElement LastName;
	@FindBy(xpath="//input[@class='form-control input-text' and @name='email']")
	WebElement email;
	@FindBy(xpath="//input[@name='email_confirm']")
	WebElement ConfirmEmail;
	@FindBy(xpath="//input[contains(@name,'username')]")
	WebElement UserName;
	@FindBy(xpath="//input[contains(@type,'password' )and  @name='password']")
	WebElement password;
	@FindBy(xpath="//input[@name='passwordconfirm']")
	WebElement ConfirmPassword;
	@FindBy(name="agreeTerms")
	WebElement AgreeTerms;
	@FindBy(xpath="//input[@name='submitButton']")
	WebElement Submit;
	
	public SignupPage()
	{
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void SelectEdition(String edition)
	{
		
		Select editions = new Select(Edition);
		if(edition.equalsIgnoreCase("free"))
				editions.selectByVisibleText("Free Edition");
		else if(edition.equalsIgnoreCase("CRM PRO"))
			editions.selectByVisibleText("CRMPRO - $29.95 user/mo.");
	}
	
	public void EnterFirstName(String fname)
	{
		
		FirstName.sendKeys(fname);
		log.info("first name entered");
		log.error(FirstName);
	}
	
	public void EnterLastName(String lname)
	{
		
		LastName.sendKeys(lname);
		log.info("Last name entered");
		log.error(LastName);
	}
	
	public void EnterEmail(String mail)
	{
		
		email.sendKeys(mail);
		log.info(" Email entered");
		log.error(email);
	}
	
	public void EnterConfirmEmail(String confirmmail)
	{
		
		ConfirmEmail.sendKeys(confirmmail);
		log.info("confirm email entered");
		log.error(ConfirmEmail);
	}
	
	public void EnterUserName(String uname)
	{
		
		UserName.sendKeys(uname);
		log.info("User name entered");
		log.error(UserName);
	}
	
	public void EnterPassword(String pwd)
	{
		
		password.sendKeys(pwd);
		log.info("password entered");
		log.error(password);
	}
	
	public void EnterConfirmationPassword(String confirmpwd)
	{
		
		ConfirmPassword.sendKeys(confirmpwd);
		log.info("confrim password entered");
		log.error(ConfirmPassword);
	}
	
	public void SelectAgreeTerms()
	{
		
		if(!AgreeTerms.isSelected())
			AgreeTerms.click();
	}
	
	public void Submit()
	{
		Submit.click();
	}
	
}
