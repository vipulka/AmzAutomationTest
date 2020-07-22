package com.amazon.qa.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Account & Lists')]")
	WebElement signIn;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchTextBox;
	
	@FindBy(xpath="//span[@id='a-autoid-0-announce']")
	WebElement sortDropdown;
	
	@FindBy(xpath="//a[@id='s-result-sort-select_1']")
	WebElement sortAscending;
	
	@FindBy(xpath="//span[contains(text(),'Apple iPhone 11 (64GB) - Purple')]")
	WebElement sampleProduct;
	
	@FindBy(xpath="//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")
	WebElement searchButton;
	
	
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle(){
		 return driver.getTitle();
	}
	public SignInPage clickOnSignInbtn(){
		signIn.click();
		return new SignInPage();
	}
	
	public void SearchProduct(){
		searchTextBox.sendKeys("iphone11");
		searchButton.click();
		
	}
	
	public void sortProduct(){
		sortDropdown.click();
		sortAscending.click();
	}
	
	public ProductPage addProductToCart(){
		sampleProduct.click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    return new ProductPage();
	    
	}
	
	
	
	

}
