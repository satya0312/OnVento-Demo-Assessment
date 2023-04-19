package com.ui.test.selenim.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {
	public RegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "first")
	WebElement firstName;

	@FindBy(name = "last")
	WebElement lastName;

	@FindBy(name = "email")
	WebElement emailAddress;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "passwordConfirmation")
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@value='agreeToPrivacyPolicy']")
	WebElement termsOfUseAndPrivacyPolicy;

	@FindBy(xpath = "//button[text()='Sign up']")
	WebElement signUpButton;

	@FindBy(xpath = "//input[@type='file']")
	WebElement uploadProfilePicture;

	@FindBy(xpath = "//button[text()='ALLOW ALL']")
	WebElement allowAllCookies;

	@FindBy(xpath = "//div[@id='mui-component-select-country']")
	WebElement country;

	@FindBy(xpath = "//ul[@role='listbox']/li")
	List<WebElement> countryValues;

	@FindBy(xpath = "//input[@value='agreeToEventPrivacyPolicy']")
	WebElement eventPrivacyPolicy;

	@FindBy(xpath = "//button[text()='Complete Registration']")
	WebElement completeRegistrationButton;

	@FindBy(xpath = "//div[@class='code-input']/input")
	List<WebElement> otpBoxes;

	public void clickAllowAllCookies() {
		click(allowAllCookies);
	}

	public void enterFirstName(CharSequence keysToFirstName) {
		type(firstName, keysToFirstName);
	}

	public void enterLastName(CharSequence keysToFirstName) {
		type(lastName, keysToFirstName);
	}

	public void enterEmailAddress(CharSequence keysToFirstName) {
		type(emailAddress, keysToFirstName);
	}

	public void enterPassword(CharSequence keysToFirstName) {
		type(password, keysToFirstName);
	}

	public void enterConfirmPassword(CharSequence keysToFirstName) {
		type(confirmPassword, keysToFirstName);
	}

	public void checkTermsOfUseAndPrivacyPolicy() {
		clickByJs(termsOfUseAndPrivacyPolicy);
	}

	public void clickSignUp() {
		click(signUpButton);
	}

	public void uploadProfilePicture(String pathOfTheProfilePicture) {
		uploadProfilePicture.sendKeys(pathOfTheProfilePicture);
	}

	public void enterOtp() {
		int i = 1;
		for (WebElement otpBox : otpBoxes) {
			otpBox.sendKeys(Integer.toString(i));
			i++;
		}
	}

	public void selectCountry(String countryName) {
		selectDropdown(country, countryValues, countryName);
	}

	public void checkEventPrivacyPolicy() {
		clickByJs(eventPrivacyPolicy);
	}

	public void clickCompleteRegistration() {
		click(completeRegistrationButton);
	}

}
