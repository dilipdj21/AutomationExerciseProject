package com.automationexercise.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.qa.base.Base;
import com.automationexercise.qa.pages.LoginPage;
import com.automationexercise.qa.pages.RegisterPage;
import com.automationexercise.qa.utils.Utilities;

public class LoginTest extends Base {
	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		loadPropertiesFile();
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1, dataProvider = "validCredentialSupplier")
	public void verifyLoginUserWithCorrectEmailAndPassword(String email, String password) {

		RegisterPage registerpage = new RegisterPage(driver);
		boolean homepage = registerpage.verifyHomePage();
		System.out.println(homepage);
		Assert.assertEquals(homepage, true);
		registerpage.clickOnSignUpAndLoginButton();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(email);
		loginpage.enterPassword(password);
		loginpage.clickOnLoginButton();
	}

	@DataProvider(name = "validCredentialSupplier")
	public Object[][] supplyTestData() {
		Object[][] data = Utilities.getTestDataFromExcel("Sheet1");
		return data;
	}

	@Test(priority = 2)
	public void verifyLoginUserWithInCorrectEmailAndPassword() {
		RegisterPage registerpage = new RegisterPage(driver);
		boolean homepage = registerpage.verifyHomePage();
		System.out.println(homepage);
		Assert.assertEquals(homepage, true);
		registerpage.clickOnSignUpAndLoginButton();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress("dilipdj@gmail.com");
		loginpage.enterPassword("asdfasdf3423423");
		loginpage.clickOnLoginButton();
		String EmailWarningMessage = loginpage.retriveEmailOrPasswordIsIncorrectMessage();
		Assert.assertEquals(EmailWarningMessage, "Your email or password is incorrect!");
	}

	@Test(priority = 3)
	public void registerUserWithExistingEmail() {
		RegisterPage registerpage = new RegisterPage(driver);
		boolean homepage = registerpage.verifyHomePage();
		System.out.println(homepage);
		Assert.assertEquals(homepage, true);
		registerpage.clickOnSignUpAndLoginButton();
		registerpage.enterNameField("dilip");
		registerpage.enterEmailAddressField("dilipdj21@gmail.com");
		registerpage.clickOnSignUpButton();
		String warningMessage = registerpage.retriveEmailAddressAlreadyExistWarningmessage();
		Assert.assertEquals(warningMessage, "Email Address already exist!");
	}
}
