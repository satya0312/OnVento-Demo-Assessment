package com.ui.test.selenim.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {
	public DashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='LIVE WALL']")
	WebElement liveWall;

	@FindBy(id = "newPost")
	WebElement newPost;

	@FindBy(xpath = "//button[@class='add-new-post']")
	WebElement addNewPostPlusIcon;

	@FindBy(xpath = "//div[contains(@class,'single-post-container')]/descendant::div[@class='post-container']")
	WebElement latestMessage;

	@FindBy(xpath = "//div[@class='wall-spinner']")
	WebElement wallSpinner;

	public void waitUnitDashboardPageIsShown() {
		waitUntilElementIsVisible(liveWall);
	}

	public void enterNewPost(String postContent) {
		type(newPost, postContent);
		click(addNewPostPlusIcon);
		waitUntilElementIsVisible(wallSpinner);
		waitUntilElementIsInVisible(wallSpinner);
	}

	public String getLatestMessage() {
		return latestMessage.getText();
	}
}
