package com.automationexercise.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	WebDriver driver;

	@FindBy(xpath = "//a//i[@class='fa fa-envelope']")
	private WebElement contactUsButton;

	@FindBy(xpath = "//div//input[@name='name']")
	private WebElement nameField;

	@FindBy(xpath = "//div//input[@name='email']")
	private WebElement emailField;

	@FindBy(xpath = "//div//input[@name='subject']")
	private WebElement subjectField;

	@FindBy(xpath = "//div//textarea[@name='message']")
	private WebElement yourMessageHereField;

	@FindBy(xpath = "//div//input[@name='upload_file']")
	private WebElement chooseFileButton;

	@FindBy(xpath = "//div//input[@name='submit']")
	private WebElement SubmitButton;

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnContactUsButton() {
		contactUsButton.click();
	}

	public void enterName(String name) {
		nameField.sendKeys(name);
	}

	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}

	public void enterSubject(String subject) {
		subjectField.sendKeys(subject);
	}

	public void enterYourMessageHere(String message) {
		yourMessageHereField.sendKeys(message);
	}

	public void clickOnChooseFile(String path) {
		chooseFileButton.sendKeys(path);
	}

	public void clickOnSubmitButton() {
		SubmitButton.click();
	}
}
