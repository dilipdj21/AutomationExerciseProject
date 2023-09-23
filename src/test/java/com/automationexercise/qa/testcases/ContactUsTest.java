package com.automationexercise.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.qa.base.Base;
import com.automationexercise.qa.pages.ContactUsPage;
import com.automationexercise.qa.pages.RegisterPage;

public class ContactUsTest extends Base {
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
	public void verifyContactUs() {
		RegisterPage registerpage = new RegisterPage(driver);
		boolean homepage = registerpage.verifyHomePage();
		System.out.println(homepage);
		Assert.assertEquals(homepage, true);
		ContactUsPage contactpage = new ContactUsPage(driver);
		contactpage.clickOnContactUsButton();
		contactpage.enterName("Dilip");
		contactpage.enterEmail("dilip@gmail.com");
		contactpage.enterSubject("Hello World");
		contactpage.enterYourMessageHere("Hello all,Welcome to the world of Automation");
		contactpage
				.clickOnChooseFile("/Users/noonacademy/eclipse-workspace/AutomationExerciseProject/Upload/lamp.jpeg");
		contactpage.clickOnContactUsButton();
	}
}
