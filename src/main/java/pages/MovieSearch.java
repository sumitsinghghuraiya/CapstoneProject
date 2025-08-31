package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FrameworkConstants;
import utils.WaitUtils;

import java.time.Duration;
import java.util.List;

public class MovieSearch {

    private WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//input[@class='sc-ifipx4-9 cpXaIl']")
	private WebElement citySearch;

	@FindBy(xpath = "//div[@data-result-item='true']")
	private WebElement firstCity;
    // Recommended movie cards
    @FindBy(xpath = "//div[contains(@class,'sc-133848s-3')]//a[@class='sc-133848s-11 sc-lnhrs7-5 ctsexn bHVBt']")
    private List<WebElement> suggestedMovies;

    // Movie title on detail page
    @FindBy(xpath = ("//h1[@class='sc-qswwm9-6 ea-drWB']"))
    private WebElement movieTitle;

    // Movie poster image section
    @FindBy(xpath = "//section[@class='sc-bsek5f-0 jNOshi']")
    private WebElement posterImage;

    // About movie section
    @FindBy(xpath = "//h4[text()='About the movie']")
    private WebElement aboutMovieSection;

    // Book ticket button
    @FindBy(xpath = "//div[@class='sc-qswwm9-8 fNtHgG']//button//span[text()='Book tickets']")
    private WebElement bookTicketBtn;

    // Movies navigation tab
    @FindBy(xpath = "//a[text()='Movies']")
    private WebElement moviesMenu;

    // Link to upcoming movies
    @FindBy(xpath = "//a//img[@alt='Coming Soon']")
    private WebElement upcomingMoviesLink;

    // "Now Showing" section image
    @FindBy(xpath = "//img[@alt='Now Showing']")
    private WebElement nowShowingLink;

    // Constructor
    public MovieSearch(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.TIMEOUT));
        PageFactory.initElements(driver, this);
    }
    public void searchAndSelectCity(String cityName) {
    	wait.until(ExpectedConditions.visibilityOf(citySearch)).sendKeys(cityName);
	    wait.until(ExpectedConditions.elementToBeClickable(firstCity)).click();
	}
    
    // Select the first suggested movie
    public void openFirstSuggestedMovie() {
        if (!suggestedMovies.isEmpty()) {
           suggestedMovies.get(1).click();
        } else {
            throw new RuntimeException("No movies found in suggestions!");
        }
    }

    // Verify title
    public boolean isTitleVisible() {
        return WaitUtils.waitForElementVisible(driver, movieTitle).isDisplayed();
    }

    // Verify poster
    public boolean isPosterVisible() {
        return WaitUtils.waitForElementVisible(driver, posterImage).isDisplayed();
    }

    // Verify about section
    public boolean isAboutMovieVisible() {
        return WaitUtils.waitForElementVisible(driver, aboutMovieSection).isDisplayed();
    }

    // Verify booking option
    public boolean isBookingButtonVisible() {
        return WaitUtils.waitForElementVisible(driver, bookTicketBtn).isDisplayed();
    }

    // Navigate to movies tab
    public void goToMoviesTab() {
        WaitUtils.waitForElementClickable(driver, moviesMenu).click();
    }

    // Click on upcoming movies
    public void goToUpcomingMovies() {
        WaitUtils.waitForElementClickable(driver, upcomingMoviesLink).click();
    }

    // Check now showing link
    public boolean isNowShowingVisible() {
        return WaitUtils.waitForElementVisible(driver, nowShowingLink).isDisplayed();
    }
}
