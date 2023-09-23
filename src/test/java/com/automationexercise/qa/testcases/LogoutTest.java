package com.automationexercise.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.qa.base.Base;
import com.automationexercise.qa.pages.LoginPage;
import com.automationexercise.qa.pages.LogoutPage;
import com.automationexercise.qa.pages.RegisterPage;

public class LogoutTest extends Base {
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

	@Test(priority = 1)
	public void verifyLogoutUser() {

		RegisterPage registerpage = new RegisterPage(driver);
		boolean homepage = registerpage.verifyHomePage();
		System.out.println(homepage);
		Assert.assertEquals(homepage, true);
		registerpage.clickOnSignUpAndLoginButton();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(prop.getProperty("validUsername"));
		loginpage.enterPassword(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.clickOnLogoutButton();
	}
}
