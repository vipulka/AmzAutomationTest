package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class CreateAccountPage extends TestBase {
	
	

	@FindBy(id = "ap_customer_name")
	WebElement yourName;

	@FindBy(id = "ap_phone_number")
	WebElement phoneNumber;

	@FindBy(id = "ap_password")
	WebElement password;

	@FindBy(id = "continue")
	WebElement next;

	@FindBy(xpath = "//span[contains(text(),'Please solve this')]")
	WebElement successMessage;
	
	public CreateAccountPage(){
		PageFactory.initElements(driver, this);
	}

	public RegistrationSuccessPage enterDetailsCreateAccount() {

		yourName.sendKeys("Test Amzon user");
		phoneNumber.sendKeys("9899999999");
		password.sendKeys("qqqqqq");
		next.click();
		return new RegistrationSuccessPage();

	}
	
	public String verifyPageTitleAccount(){
		return driver.getTitle();
	}
	
	public String getMessage(){
		
		return successMessage.getText();
	}

}
