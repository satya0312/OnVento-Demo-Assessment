package com.ui.test.selenim.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='menu-wrapper ']/descendant::span[text()='Join as participant']")
	WebElement joinAsParticipantButton;

	public void clickJoinAsParticipant() {
		click(joinAsParticipantButton);
	}

}
