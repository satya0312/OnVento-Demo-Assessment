package com.ui.test.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ui.test.selenim.pages.DashboardPage;
import com.ui.test.selenim.pages.HomePage;
import com.ui.test.selenim.pages.RegistrationPage;
import com.ui.test.selenium.utils.DateUtil;
import com.ui.test.selenium.utils.RandomUtil;

public class DemoTest extends BaseTest {

	@Test
	public void DemoExample() throws InterruptedException {
		String postMessage = "The current date and time is [" + DateUtil.getTime("YYYY-MM-DD HH:MM:SS") + "]";
		HomePage homePage = new HomePage(driver);
		homePage.clickJoinAsParticipant();
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.clickAllowAllCookies();
		registrationPage.enterFirstName("Webdriver");
		registrationPage.enterLastName("Selenium");
		registrationPage.enterEmailAddress("testbot-swd-" + RandomUtil.getRandomNumber() + "@onvent.online");
		registrationPage.enterPassword("Selenium22#");
		registrationPage.enterConfirmPassword("Selenium22#");
		// registrationPage.uploadProfilePicture(
		// "C:\\Users\\Headway\\eclipse-workspace\\ui-test\\src\\test\\resources\\profile-pictrues\\Man.png");
		registrationPage.checkTermsOfUseAndPrivacyPolicy();
		registrationPage.clickSignUp();
		registrationPage.enterOtp();
		registrationPage.selectCountry("Ukraine");
		registrationPage.checkEventPrivacyPolicy();
		registrationPage.clickCompleteRegistration();
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.waitUnitDashboardPageIsShown();
		dashboardPage.getScreenshot(
				"ui-test\\src\\test\\resources\\outut-screenshots\\FIRST_[" + DateUtil.getTime("HH-MM-SS") + "].png");
		dashboardPage.enterNewPost(postMessage);
		String messageFromUI = dashboardPage.getLatestMessage();
		System.out.println("Message from UI "+messageFromUI);
		System.out.println("Message from expected "+postMessage);
		Assert.assertEquals(messageFromUI, postMessage);

	}
}