package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class ProductPage extends TestBase {

	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addToCartBtn;

	@FindBy(xpath = "//div[@class='a-row a-spacing-micro']//span[contains(text(),'(1 item):')]")
	WebElement quantity;

	@FindBy(xpath = "//span[contains(text(),'Account & Lists')]")
	WebElement accountAndLists;

	@FindBy(xpath = "//span[contains(text(),'Sign Out')]")
	WebElement logoutBtn;

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void addProudctToCartFromProductPage(){
		addToCartBtn.click();
	}

	public String verifyProductQuantity() {
		return quantity.getText();
	}

	public void logoutFromAmazon() {

		Actions action = new Actions(driver);
		action.moveToElement(accountAndLists).build().perform();
		logoutBtn.click();
	}

}
