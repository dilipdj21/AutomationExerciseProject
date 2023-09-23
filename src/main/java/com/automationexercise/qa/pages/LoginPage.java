package com.automationexercise.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(xpath = "(//form//input[@name='email'])[1]")
	private WebElement emailAddressField;

	@FindBy(xpath = "//form//input[@name='password']")
	private WebElement passwordField;

	@FindBy(xpath = "(//form//button[@type='submit'])[1]")
	private WebElement loginButton;

	@FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
	private WebElement yourEmailIdOrPasswordisIncorrect;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterEmailAddress(String email) {
		emailAddressField.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

	public String retriveEmailOrPasswordIsIncorrectMessage() {
		String EmailPasswordWarningText = yourEmailIdOrPasswordisIncorrect.getText();
		return EmailPasswordWarningText;
	}
}
