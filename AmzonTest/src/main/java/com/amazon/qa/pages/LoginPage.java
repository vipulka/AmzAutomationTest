package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id = "ap_email")
	WebElement emailAddress;

	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueBtn;

	@FindBy(id = "ap_passwordl")
	WebElement password;

	@FindBy(id = "signInSubmit")
	WebElement LoginBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage loginintoApplication() {
		emailAddress.sendKeys(prop.getProperty("username"));
		continueBtn.click();
		password.sendKeys(prop.getProperty("password"));
		LoginBtn.click();
		return new HomePage();
		

	}

}
