package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class SignInPage extends TestBase {
	
	@FindBy(xpath="//a[@id='createAccountSubmit']")
	WebElement createAmazonAccount;
	@FindBy(id = "ap_email")
	WebElement emailAddress;

	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueBtn;

	@FindBy(id="ap_password")
	WebElement password;

	@FindBy(id = "signInSubmit")
	WebElement LoginBtn;

	public HomePage loginintoApplication() {
		emailAddress.sendKeys(prop.getProperty("username"));
		continueBtn.click();
		password.sendKeys(prop.getProperty("password"));
		LoginBtn.click();
		return new HomePage();
	}
	
	public SignInPage(){
		PageFactory.initElements(driver, this);
	}
	
	public CreateAccountPage createNewAmzonAccount(){
		createAmazonAccount.click();
		
		return new CreateAccountPage();
		
		
		
	}

}
