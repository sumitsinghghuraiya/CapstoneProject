package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

import java.util.List;

public class CitySearch {

    private WebDriver driver;

    // ======= Constructor =======
    public CitySearch(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ======= Locators =======
    @FindBy(xpath = "//input[@class='sc-ifipx4-9 cpXaIl']")
    private WebElement townSearchInput;

    @FindBy(xpath = "//div[@class='sc-5d56x9-0 hIDoFD']")
    private WebElement firstSuggestedTown;

    @FindBy(xpath = "//div[@class='sc-5d56x9-0 hIDoFD']//span")
    private List<WebElement> townSearchResults;

    @FindBy(xpath = "//div[@class='sc-fv93km-1 fZhJNQ']")
    private WebElement noResultMessage;

    @FindBy(xpath = "//li//p")
    private List<WebElement> townIconList;

    @FindBy(xpath = "//div[@id='common-header-region']//span")
    private WebElement townDropdownLabel;

    @FindBy(xpath = "//p[normalize-space(text())='View All Cities']")
    private WebElement expandAllTownsLink;

    @FindBy(xpath = "//li[@class='sc-1a0jimq-0 hhOIxv']")
    private List<WebElement> allTownOptions;


    // ======= Methods =======
    public void enterTownName(String townName) {
        WaitUtils.waitForElementVisible(driver, townSearchInput).sendKeys(townName);
    }

    public boolean checkTownInSearchResults(String townName) {
        for (WebElement town : townSearchResults) {
            if (town.getText().equalsIgnoreCase(townName)) {
                return true;
            }
        }
        return false;
    }

    public void pickFirstTownResult() {
        WaitUtils.waitForElementClickable(driver, townSearchResults.get(0)).click();
    }

    public String fetchTownFromDropdown() {
        return WaitUtils.waitForElementVisible(driver, townDropdownLabel).getText();
    }

    public String fetchErrorMessage() {
        return noResultMessage.getText();
    }

    public void pickTownByIcon(String townName) {
        for (WebElement icon : townIconList) {
            if (icon.getText().trim().toLowerCase().contains(townName.toLowerCase())) {
                icon.click();
                break;
            }
        }
    }

    public void openAllTownsView() {
        WaitUtils.waitForElementClickable(driver, expandAllTownsLink).click();
    }

    public boolean checkTownInAllTowns(String townName) {
        for (WebElement town : allTownOptions) {
            if (town.getText().equalsIgnoreCase(townName)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTownInPopularList(String townName) {
        for (WebElement town : townIconList) {
            if (town.getText().equalsIgnoreCase(townName)) {
                return true;
            }
        }
        return false;
    }
}
