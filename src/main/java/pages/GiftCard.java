package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FrameworkConstants;
import utils.WaitUtils;

public class GiftCard {

    WebDriver driver;
    WebDriverWait wait;
    // Constructor
    public GiftCard(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.TIMEOUT));
        PageFactory.initElements(driver, this);
    }

    // Locators using PageFactory
    @FindBy(xpath = "//input[@class='sc-ifipx4-9 cpXaIl']")
	private WebElement citySearch;

	@FindBy(xpath = "//div[@data-result-item='true']")
	private WebElement firstCity;
    @FindBy(xpath = "//div[@class='sc-1or3vea-19 bfNncl']//a[@href='/giftcards' and text()='Gift Cards']")
    private WebElement giftCardSectionLink;

    @FindBy(xpath = "//div[text()='Check Gift Card Balance']")
    private WebElement checkBalanceIcon;

    @FindBy(xpath = "//input[@id='gift-voucher']")
    private WebElement voucherCodeInput;

    @FindBy(xpath = "//div[@class='sc-zgl7vj-7 dMHyDB']")
    private WebElement checkBalanceButton;

    @FindBy(xpath = "//div[@id='error-gift-voucher']")
    private WebElement errorMessage;

    // Page Actions
    public void searchAndSelectCity(String cityName) {
	    wait.until(ExpectedConditions.visibilityOf(citySearch)).sendKeys(cityName);
	    wait.until(ExpectedConditions.elementToBeClickable(firstCity)).click();
	}
    public void navigateToGiftCardSection() {
    	WaitUtils.waitForElementClickable(driver, giftCardSectionLink).click();
    }

    public boolean isCheckBalanceIconDisplayed() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", checkBalanceIcon);
        return checkBalanceIcon.isDisplayed();
    }

    public void clickCheckBalanceIcon() {
    	WaitUtils.waitForElementClickable(driver, checkBalanceIcon).click();;
    }

    public void enterVoucherCode(String code) {
    	WaitUtils.waitForElementVisible(driver,voucherCodeInput).clear();
        voucherCodeInput.sendKeys(code);
    }

    public void clickCheckBalanceButton() {
    	WaitUtils.waitForElementClickable(driver, checkBalanceButton).click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}