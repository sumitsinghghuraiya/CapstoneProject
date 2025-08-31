package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;

	// ===== Constructor =====
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// ===== Page Elements =====
	@FindBy(xpath = "//input[@class='sc-ifipx4-9 cpXaIl']")
	private WebElement citySearch;

	@FindBy(xpath = "//div[@data-result-item='true']")
	private WebElement firstCity;

	@FindBy(xpath = "//div[normalize-space(text())='Sign in']")
	private WebElement loginIcon;

	@FindBy(xpath = "//input[@class='sc-1dpf1eo-0 gjQhmj']")
	private WebElement mobileField;

	@FindBy(xpath = "//div[text()='Continue']")
	private WebElement continueBtn;

	@FindBy(xpath = "//div[@class='sc-zgl7vj-7 iFxnzW']")
	private WebElement disabledContinueBtn;
	@FindBy(xpath = "//div[normalize-space(text())='Continue']")
	private WebElement enabledContinueBtn;

	@FindBy(xpath = "//input[@type='tel']")
	List<WebElement> OTPField;

	@FindBy(xpath = "//div[text()='Invalid mobile number']")
	private WebElement ErrorMsg;

	@FindBy(xpath = "//div[@class='sc-1ydq0aj-6 gnsbYm']")
	private WebElement closeButton;
	@FindBy(xpath = "//div[@class='sc-1ydq0aj-0 bIaakI']")
	private WebElement BackBtn;

	// ===== Actions =====
	public void searchAndSelectCity(String cityName) {
	    wait.until(ExpectedConditions.visibilityOf(citySearch)).sendKeys(cityName);
	    wait.until(ExpectedConditions.elementToBeClickable(firstCity)).click();
	}

	public void navigateToLogin() {
	    wait.until(ExpectedConditions.elementToBeClickable(loginIcon)).click();
	}

	public void clickProceed() {
	    wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
	}

	public boolean isOTPFieldVisible() {
	    return wait.until(ExpectedConditions.visibilityOf(OTPField.get(0))).isDisplayed();
	}

	public void returnToLogin() {
	    wait.until(ExpectedConditions.visibilityOf(BackBtn)).click();
	}

	public String fetchErrorMessage() {
	    return ErrorMsg.getText();
	}

	public boolean checkMobileFieldVisible() {
	    return wait.until(ExpectedConditions.visibilityOf(mobileField)).isDisplayed();
	}

	public boolean checkProceedButtonVisible() {
	    try {
	        return continueBtn.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

	public boolean checkProceedButtonDisabled() {
	    return wait.until(ExpectedConditions.visibilityOf(disabledContinueBtn)).isDisplayed();
	}

	public boolean checkProceedButtonEnabled() {
	    return wait.until(ExpectedConditions.visibilityOf(enabledContinueBtn)).isDisplayed();
	}

	public void inputMobileNumber(String number) throws InterruptedException {
	    WebElement mobileField = driver.findElement(By.id("userMobileNumber"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].value = '';", mobileField);
	    wait.until(ExpectedConditions.elementToBeClickable(mobileField)).sendKeys(number);
	}

	public void dismissLoginPopup() {
	    closeButton.click();
	}

}