package com.automationexercise.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	WebDriver driver;

	@FindBy(xpath = "//a//i[@class='fa fa-home']")
	private WebElement homePage;

	@FindBy(xpath = "//a//i[@class='fa fa-lock']")
	private WebElement signupAndLogin;

	@FindBy(xpath = "//form//input[@name='name']")
	private WebElement nameField;

	@FindBy(xpath = "(//form//input[@name='email'])[2]")
	private WebElement emailAddressField;

	@FindBy(xpath = "(//form//button[@type='submit'])[2]")
	private WebElement signUpButton;

	@FindBy(xpath = "//span//input[@id='id_gender1']")
	private WebElement mrAndMrs;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@id='newsletter']")
	private WebElement signupforournewsletter;

	@FindBy(xpath = "//input[@id='optin']")
	private WebElement receiveSpecialOffersFromOurPartners;

	@FindBy(xpath = "//input[@id='first_name']")
	private WebElement firstNameField;

	@FindBy(xpath = "//input[@name='last_name']")
	private WebElement lastNameField;

	@FindBy(xpath = "//input[@name='company']")
	private WebElement companyField;

	@FindBy(xpath = "//input[@name='address1']")
	private WebElement address1Field;

	@FindBy(xpath = "//input[@name='address2']")
	private WebElement address2Field;

	@FindBy(xpath = "//input[@name='state']")
	private WebElement stateField;

	@FindBy(xpath = "//input[@name='city']")
	private WebElement cityField;

	@FindBy(xpath = "//input[@name='zipcode']")
	private WebElement zipcodeField;

	@FindBy(xpath = "//input[@name='mobile_number']")
	private WebElement mobilenumberField;

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	private WebElement createAccountButton;

	@FindBy(xpath = "//form//p[text()='Email Address already exist!']")
	private WebElement emailAddressAlreadyExist;

	@FindBy(xpath = "(//a//i[@class='fa fa-list'])[1]")
	private WebElement testCasesButton;
	
	@FindBy(xpath="//h2//b[text()='Test Cases']")
	private WebElement testCasesText;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean retriveTestCasesText() {
		boolean testcases = testCasesText.isDisplayed();
		return testcases;	
	}

	public void clickOnTestCasesButton() {
		testCasesButton.click();
	}

	public boolean verifyHomePage() {
		boolean homepage = homePage.isDisplayed();
		return homepage;
	}

	public String retriveEmailAddressAlreadyExistWarningmessage() {
		String emailAddress = emailAddressAlreadyExist.getText();
		return emailAddress;
	}

	public void waitUntil() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='submit'])[1]")));
	}

	public void clickOnCreateAccount() {
		createAccountButton.click();
	}

	public void enterMobileNumber(String mobilenumber) {
		mobilenumberField.sendKeys(mobilenumber);
	}

	public void enterZipCode(String zipcode) {
		zipcodeField.sendKeys(zipcode);
	}

	public void enterCity(String city) {
		cityField.sendKeys(city);
	}

	public void enterState(String state) {
		stateField.sendKeys(state);
	}

	public void enterAddress2(String address2) {
		address2Field.sendKeys(address2);
	}

	public void enterAddress1(String address1) {
		address1Field.sendKeys(address1);
	}

	public void enterCompany(String company) {
		companyField.sendKeys(company);
	}

	public void enterLastName(String lname) {
		lastNameField.sendKeys(lname);
	}

	public void enterFirstName(String fname) {
		firstNameField.sendKeys(fname);
	}

	public void clickOnNewsLetter() {
		signupforournewsletter.click();
	}

	public void clickOnSpecialOffers() {
		receiveSpecialOffersFromOurPartners.click();
	}

	public void clickOnSignUpAndLoginButton() {
		signupAndLogin.click();
	}

	public void enterNameField(String nameText) {
		nameField.sendKeys(nameText);
	}

	public void enterEmailAddressField(String email) {
		emailAddressField.sendKeys(email);
	}

	public void clickOnSignUpButton() {
		signUpButton.click();
	}

	public void selectTitle() {
		mrAndMrs.click();
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void selectDOB() {
		WebElement date = driver.findElement(By.xpath("(//div[@class='form-group']//select)[1]"));
		Select select = new Select(date);
		select.selectByValue("26");
		WebElement month = driver.findElement(By.xpath("(//div[@class='form-group']//select)[2]"));
		Select select1 = new Select(month);
		select1.selectByVisibleText("October");
		WebElement year = driver.findElement(By.xpath("(//div[@class='form-group']//select)[3]"));
		Select select2 = new Select(year);
		select2.selectByValue("2000");
	}

	public void selectCountry() {
		WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
		Select select = new Select(country);
		select.selectByVisibleText("United States");
	}
}
