package com.automationexercise.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	WebDriver driver;

	@FindBy(xpath = "//a[text()=' Products']")
	private WebElement productsButton;

	@FindBy(xpath = "//h2[@class='title text-center']")
	private WebElement allProductsText;

	@FindBy(xpath = "//a[@href='/product_details/1']//i")
	private WebElement viewProduct;

	@FindBy(xpath = "//h2[text()='Blue Top']")
	private WebElement productName;

	@FindBy(xpath = "//p[text()='Category: Women > Tops']")
	private WebElement category;

	@FindBy(xpath = "(//div//span)[13]")
	private WebElement price;

	@FindBy(xpath = "//b[text()='Availability:']")
	private WebElement availability;

	@FindBy(xpath = "//b[text()='Condition:']")
	private WebElement condition;

	@FindBy(xpath = "//b[text()='Brand:']")
	private WebElement brand;

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyProductName() {
		boolean productNameText = productName.isDisplayed();
		return productNameText;	 
	}

	public void clickOnProductsButton() {
		productsButton.click();
	}

	public boolean verifyAllProductsText() {
		boolean allproductsText = allProductsText.isDisplayed();
		return allproductsText;
	}
	
	public boolean verifyPriceText() {
		boolean priceText = price.isDisplayed();
		return priceText;	
	}

	public void clickOnViewProduct() {
		viewProduct.click();
	}
}
