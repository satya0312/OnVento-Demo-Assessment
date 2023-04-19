package com.ui.test.selenim.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ui.test.selenium.utils.DateUtil;

public class BasePage {
	public WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToUrl(String url) {
		driver.get(url);
	}

	public void type(WebElement element, CharSequence keysToSend) {
		waitUntilElementIsVisible(element);
		element.clear();
		element.sendKeys(keysToSend);
	}

	public void click(WebElement element) {
		waitUntilElementIsVisible(element);
		element.click();
	}

	public void clickByJs(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void waitUntilElementIsVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilElementIsInVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitUntilElementIsClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	public void selectDropdown(WebElement elementToShowOptions, List<WebElement> listBox, String value) {
		click(elementToShowOptions);
		for (WebElement dropdownValue : listBox) {
			if (dropdownValue.getText().equalsIgnoreCase(value)) {
				click(dropdownValue);
				break;
			}
		}

	}

	public void getScreenshot(String destination) {

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail("Exception occured while taking screenshot" + e.getMessage());
		}
	}
}
