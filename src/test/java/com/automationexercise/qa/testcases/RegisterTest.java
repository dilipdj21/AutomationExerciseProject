package com.automationexercise.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.qa.base.Base;
import com.automationexercise.qa.pages.RegisterPage;
import com.automationexercise.qa.utils.Utilities;

public class RegisterTest extends Base {
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
	public void verifyRegisterUser() {

		RegisterPage registerpage = new RegisterPage(driver);
		boolean homepage = registerpage.verifyHomePage();
		System.out.println(homepage);
		Assert.assertEquals(homepage, true);
		registerpage.clickOnSignUpAndLoginButton();
		registerpage.enterNameField("dilipdj");
		registerpage.enterEmailAddressField(Utilities.genarateEmailWithTimeStamp());
		registerpage.clickOnSignUpButton();
		registerpage.selectTitle();
		registerpage.enterPassword("rqrqerq1213");
		registerpage.selectDOB();
		registerpage.clickOnNewsLetter();
		registerpage.clickOnSpecialOffers();
		registerpage.enterFirstName("dilip");
		registerpage.enterLastName("Jadhav");
		registerpage.enterCompany("OrangeHRM");
		registerpage.enterAddress1("No 420");
		registerpage.enterAddress2("Hebbal");
		registerpage.selectCountry();
		registerpage.enterState("Karnataka");
		registerpage.enterCity("Bangalore");
		registerpage.enterZipCode("560064");
		registerpage.enterMobileNumber("9898987667");
		registerpage.clickOnCreateAccount();
	}

	@Test(priority = 2)
	public void verifyTestCasesPage() {
		RegisterPage registerpage = new RegisterPage(driver);
		boolean homepage = registerpage.verifyHomePage();
		System.out.println(homepage);
		Assert.assertEquals(homepage, true);
		registerpage.clickOnTestCasesButton();
		boolean testcases = registerpage.retriveTestCasesText();
		System.out.println(testcases);
		Assert.assertEquals(testcases, true);
	}
}
