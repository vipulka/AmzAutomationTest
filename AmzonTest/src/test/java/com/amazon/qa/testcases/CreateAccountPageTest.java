package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.CreateAccountPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.RegistrationSuccessPage;
import com.amazon.qa.pages.SignInPage;

public class CreateAccountPageTest extends TestBase {
	HomePage homepage;
	SignInPage signinpage;
	CreateAccountPage createaccountpage;
	RegistrationSuccessPage registrationsuccesspage;

	public CreateAccountPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		homepage = new HomePage();
		signinpage = homepage.clickOnSignInbtn();
		
		}
	
	@Test
	public void navigateToCreateAccountPageTest(){
		createaccountpage =  signinpage.createNewAmzonAccount();
		registrationsuccesspage = createaccountpage.enterDetailsCreateAccount();
		String message = createaccountpage.getMessage();
		Assert.assertEquals(message,"Please solve this puzzle so we know you are a real person");
	}
	

	
	@AfterMethod
	public void quitBrowser(){
		driver.close();
	}
	
}
