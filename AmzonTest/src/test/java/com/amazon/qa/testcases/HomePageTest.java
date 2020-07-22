package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.SignInPage;

public class HomePageTest extends TestBase {
	HomePage homepage;
	SignInPage signinpage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		homepage = new HomePage();
		}
	
	@Test(priority=1)
	public void HomePageTitleTest(){
		String title = homepage.verifyPageTitle();
		Assert.assertEquals(title,"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in" );
		
	}
	
	@Test(priority=2)
	public void navigateToSignInPage(){
		signinpage = homepage.clickOnSignInbtn();
		
	}
	
	@AfterMethod
	public void quitBrowser(){
		driver.close();
	}

}
