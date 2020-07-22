package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.ProductPage;
import com.amazon.qa.pages.SignInPage;

public class SmokeTest extends TestBase {
	HomePage homepage;
	SignInPage signinpage;
	ProductPage productpage;

	public SmokeTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		initialization();
		homepage = new HomePage();
		signinpage = homepage.clickOnSignInbtn();
	}

	@Test(priority = 1)
	public void loginToAmazonTest() {
		homepage = signinpage.loginintoApplication();
	}

	@Test(priority = 2)
	public void SearchProductTest() {
		homepage.SearchProduct();
	}

	@Test(priority = 3)
	public void sortingTest() {
		homepage.sortProduct();
	}

	@Test(priority = 4)
	public void addProductToCarAndVerifyTest() {

		productpage = homepage.addProductToCart();

		productpage.addProudctToCartFromProductPage();
		String quantity = productpage.verifyProductQuantity();
		Assert.assertTrue(quantity.contains("1"));
	}

	@Test(priority = 5)
	public void logoutfromAppTest() {
		productpage.logoutFromAmazon();
	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

}
