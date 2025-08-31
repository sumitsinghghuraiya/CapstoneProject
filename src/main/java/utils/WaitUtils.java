package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FrameworkConstants;

import java.time.Duration;

	public class WaitUtils {

	    // Wait for element to be visible
	    public static WebElement waitForElementVisible(WebDriver driver,WebElement element) {
	        return new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.TIMEOUT))
	                .until(ExpectedConditions.visibilityOf(element));
	    }

	    // Wait for element to be clickable
	    public static WebElement waitForElementClickable(WebDriver driver, WebElement element) {
	        return new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.TIMEOUT))
	                .until(ExpectedConditions.elementToBeClickable(element));
	    }

	    // Wait for element to be present in DOM
	    public static WebElement waitForElementPresent(WebDriver driver, WebElement element) {
	        return new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.TIMEOUT))
	                .until(ExpectedConditions.visibilityOf(element)); 
	        // (presenceOfElement doesn't take WebElement, so visibilityOf is safer here)
	    }

	    // Wait for text to be present in element
	    public static boolean waitForTextPresent(WebDriver driver, WebElement element, String text) {
	        return new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.TIMEOUT))
	                .until(ExpectedConditions.textToBePresentInElement(element, text));
	    }

	    // Wait for element to disappear
	    public static boolean waitForElementInvisible(WebDriver driver, WebElement element) {
	        return new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.TIMEOUT))
	                .until(ExpectedConditions.invisibilityOf(element));
	    }

		

}